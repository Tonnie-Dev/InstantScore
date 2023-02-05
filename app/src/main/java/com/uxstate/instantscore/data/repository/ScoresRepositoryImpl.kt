package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.json.JsonStringParser
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.data.remote.mappers.toModel
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.toReverseStringDate
import java.io.IOException
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class ScoresRepositoryImpl @Inject constructor(
    private val api: ScoresAPI,
    db: ScoresDatabase,
    private val fixtureDetailsJsonParser: JsonStringParser<FixtureDetails>,
    private val standingsJsonParser: JsonStringParser<MutableList<Standing>>,
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

            e.printStackTrace() // emit error
            emit(Resource.Error(errorMessage = """Unexpected Error Occurred, please try again"""))
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

        val mappedUpdatedLocalFixtures = updatedLocalFixtures.map { it.toModel() }
            .groupBy { it.league }.toSortedMap(
                compareBy<League> {
                    it.id
                }
            )
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
            emit(Resource.Error(errorMessage = """Unexpected Error Occurred, please try again"""))
            null
        }

        val fixtureDetails = remoteFixtureJsonString?.let {

            fixtureDetailsJsonParser.parsJsonString(it)
        }

        emit(Resource.Success(data = fixtureDetails))
    }

    override fun getStandings(season: Int, leagueId: Int,): Flow<Resource<MutableList<Standing>>> =
        flow {

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
            Timber.i("The response is: $response")
            val standings = response?.let {
                standingsJsonParser.parsJsonString(jsonString = it)
            }

            emit(Resource.Success(data = standings))
        }
}
