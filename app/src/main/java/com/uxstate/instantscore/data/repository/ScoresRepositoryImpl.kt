package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.json.JsonStringParser
import com.uxstate.instantscore.data.remote.json.StatsJsonParser
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.data.remote.mappers.toModel
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.safeFlowCall
import com.uxstate.instantscore.utils.toReverseStringDate
import java.io.IOException
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class ScoresRepositoryImpl @Inject constructor(
    private val api: ScoresAPI,
    db: ScoresDatabase,
    private val fixtureDetailsJsonParser: JsonStringParser<FixtureDetails>,
    private val standingsJsonParser: JsonStringParser<MutableList<Standing>>,
    private val liveFixturesJsonParser: JsonStringParser<MutableList<Fixture>>,
    private val statsJsonParser: StatsJsonParser
) : ScoresRepository {
    private val dao = db.dao

    override fun getFixturesByDate(
        isRefresh: Boolean,
        date: LocalDate
    ): Flow<Resource<Map<League, List<Fixture>>>> = flow {

        // emit loading at the onset
        emit(Resource.Loading(isLoading = true))

        // fetch locally
        val localFixtures = dao.getFixturesByDate(
            dayOfMonth = date.dayOfMonth, month = date.monthValue, year = date.year
        )

        val mappedLocalFixtures = localFixtures.map { it.toModel() }
            .groupBy {
                it.league
            }
            .toSortedMap(
                compareBy<League> { it.id }.thenBy {
                    it.name
                }
            )

        // emit local fixtures
        emit(Resource.Success(data = mappedLocalFixtures))

        // decide if local cache will suffice

        val useLocalCache = localFixtures.isNotEmpty() && !isRefresh
        // emit(Resource.Success(data = localFixtures.map { it.toModel() }))
        if (useLocalCache) {

            // stop loading
            emit(Resource.Loading(isLoading = false))

            // return control
            return@flow
        }

        // past this point proceed with the API Call

        val remoteFixtures = try {

            api.getFixturesByDate(date.toReverseStringDate())
        } catch (httpException: HttpException) {
            httpException.printStackTrace() // emit error
            emit(Resource.Error(errorMessage = """Unexpected Error Occurred, please try again"""))

            // return null
            null
        } catch (ioException: IOException) {

            ioException.printStackTrace()
            emit(
                Resource.Error(
                    errorMessage = """
                Could not reach the Server, please check your connection
                    """.trimIndent()
                )
            ) // return null
            null
        } catch (e: Exception) {
            Timber.i("The Exception is: $e")
            e.printStackTrace()
            // emit error
            emit(Resource.Error(errorMessage = """Unknown Error Occurred"""))
            null
        }

        // vet and insert remote date into database
        remoteFixtures?.let { response ->
            // clear old data
            dao.clearFixtures()
            val fixtures = response.response

            // insert new data
            dao.insertFixtures(fixtures.map { it.toEntity() })
        }

        // read from single source of truth and emit
        val updatedLocalFixtures = dao.getFixturesByDate(
            dayOfMonth = date.dayOfMonth,
            month = date.monthValue,
            year = date.year
        )

        // group and sort maps
        val mappedUpdatedLocalFixtures = updatedLocalFixtures.map { it.toModel() }
            .groupBy { it.league }
            .toSortedMap(
                compareBy<League> { it.id }.thenBy {
                    it.name
                }
            )

        Timber.i("The fixtures are: $mappedUpdatedLocalFixtures")
        // emit updatedLocalFixtures

        emit(Resource.Success(data = mappedUpdatedLocalFixtures))

        // discontinue loading
        emit(Resource.Loading(isLoading = false))
    }

    override fun getFixtureDetails(fixtureId: Int): Flow<Resource<FixtureDetails>> = flow {

        val remoteFixtureJsonString = try {
            api.getFixtureDetails(fixtureId = fixtureId)
        } catch (httpException: HttpException) {
            httpException.printStackTrace() // emit error
            emit(Resource.Error(errorMessage = """Unexpected Error Occurred, please try again"""))

            // return null
            null
        } catch (ioException: IOException) {

            ioException.printStackTrace()
            emit(
                Resource.Error(
                    errorMessage = """
                Could not reach the Server, please check your connection
                    """.trimIndent()
                )
            ) // return null
            null
        }
        // catch generalized errors
        catch (e: Exception) {

            e.printStackTrace() // emit error
            emit(Resource.Error(errorMessage = """Unknown Error Occurred"""))
            null
        }

        val fixtureDetails = remoteFixtureJsonString?.let {

            fixtureDetailsJsonParser.parseJsonString(it)
        }

        emit(Resource.Success(data = fixtureDetails))
    }

    override fun getStandings(season: Int, leagueId: Int): Flow<Resource<MutableList<Standing>>> =
        flow {
            // discontinue loading
            emit(Resource.Loading(isLoading = true))
            val response = try {

                api.getStandings(season = season, leagueId = leagueId)
            } catch (e: HttpException) {

                e.printStackTrace() // emit error
                emit(
                    Resource.Error(
                        errorMessage = """
                    Unexpected Error Occurred, please try again
                        """.trimIndent()
                    )
                )

                // return null
                null
            } catch (e: IOException) {
                e.printStackTrace()
                emit(
                    Resource.Error(
                        errorMessage = """
                Could not reach the Server, please check your connection
                        """.trimIndent()
                    )
                ) // return null

                null
            } catch (e: Exception) {
                e.printStackTrace() // emit error
                emit(
                    Resource.Error(
                        errorMessage = """
                    Unexpected Error Occurred, please try again
                        """.trimIndent()
                    )
                )
                null
            }

            val standings = response?.let {
                standingsJsonParser.parseJsonString(jsonString = it)
            }

            emit(Resource.Success(data = standings))
            // discontinue loading
            emit(Resource.Loading(isLoading = false))
        }

    override fun getLiveFixtures(): Flow<Resource<Map<League, List<Fixture>>>> = flow {
        // show loading
        emit(Resource.Loading(isLoading = true))

        when (val safeResponse = safeFlowCall(Dispatchers.IO) { api.getLiveFixtures() }) {

            is Resource.Success -> {

                // pass the string response to LiveFixturesParser to get a list of Live Fixtures
                val fixturesList = safeResponse.data?.let {
                    liveFixturesJsonParser.parseJsonString(it)
                }!!

                if (fixturesList.isNotEmpty()) {

                    val mappedFixtures = fixturesList
                        .groupBy {

                            it.league
                        }
                        .toSortedMap(compareBy { it.id })

                    emit(Resource.Success(data = mappedFixtures))
                } else {
                    emit(Resource.Success(data = emptyMap()))
                }
            }

            is Resource.Error -> {

                emit(Resource.Error(errorMessage = safeResponse.errorMessage ?: ""))
            }
            else -> Unit
        }

        // discontinue loading
        emit(Resource.Loading(isLoading = false))
    }

    override fun getPlayersStats(
        statType: String,
        leagueId: Int,
        season: Int,

    ): Flow<Resource<List<PlayerStats>>> = flow {

        when (
            val safeResponse = safeFlowCall(Dispatchers.IO) {
                api.getPlayersStats(
                    statType = statType,
                    leagueId = leagueId,
                    season = season
                )
            }
        ) {

            is Resource.Error -> {
                emit(
                    Resource.Error(
                        errorMessage =
                        safeResponse.errorMessage ?: "Unknown Error Occurred"
                    )
                )
            }
            is Resource.Loading -> {
                emit(Resource.Loading(isLoading = true))
            }
            is Resource.Success -> {

                val playersList = safeResponse.data?.let {

                    statsJsonParser.parseJsonString(it)
                }!!

                if (playersList.isNotEmpty())
                    emit(Resource.Success(data = playersList))
                else
                    emit(Resource.Success(data = emptyList()))
            }
        }
    }
}

/*
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): Resource<T> {
    return withContext(dispatcher) {
        try {
            Timber.e("Inside try block: Success ")
            Resource.Success(apiCall.invoke())
        } catch (exception: Exception) {
            Timber.e(exception)
            when (exception) {

                is IOException -> {
                    Timber.e("IO Exception occurred!: $exception")
                    Resource.Error(
                            errorMessage = "Please check your internet connection and try again later",
                    )
                }

                else -> {
                    Timber.e("Inside else statement: $exception")
                    Resource.Error(
                            errorMessage = "Unknown failure occurred, please try again later",
                    )
                }
            }
        }
    }
}
*/
