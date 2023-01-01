package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.data.remote.mappers.toFakeEntity
import com.uxstate.instantscore.data.remote.mappers.toModel
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.toStringDate
import java.io.IOException
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class ScoresRepositoryImpl @Inject constructor(
    private val api: ScoresAPI,
    private val db: ScoresDatabase
) : ScoresRepository {
    private val dao = db.dao
    override fun getFixtures(isRefresh: Boolean): Flow<Resource<List<FixtureBonoko>>> = flow {

        emit(Resource.Loading(isLoading = true))

        val localFixtures = dao.getFixtures()

        val isUseLocalCache = localFixtures.isNotEmpty() || !isRefresh

        if (isUseLocalCache) {
            emit(Resource.Loading(isLoading = false))
            return@flow
        }

        val remoteFixtures = try {
            api.getFixturesByLeague(leagueId = 140)
        } catch (e: HttpException) {
            emit(Resource.Error(errorMessage = "Unknown Error Occurred"))
            null
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    errorMessage = """
                Couldn't reach the server, please check your connection
                    """.trimIndent()
                )
            )
            null
        }

        dao.clearFixtures()

        remoteFixtures?.let { fixturesResponseDTO ->

            val fixtures = fixturesResponseDTO.response

            dao.insertFakeFixtures(fixtures.map { it.toFakeEntity() })
        }

        val updatedLocalCache = dao.getFixtures()

        emit(Resource.Success(data = updatedLocalCache.map { it.toModel() }))
        emit(Resource.Loading(isLoading = false))
    }

    override fun getFixturesByDate(
        isRefresh: Boolean,
        date: LocalDate
    ): Flow<Resource<List<Fixture>>> = flow {

        Timber.i("Entering getFixtures")
        // emit loading at the onset
        emit(Resource.Loading(isLoading = true))

        // fetch locally
        val localFixtures = dao.getFixturesByDate(
            dayOfMonth = date.dayOfMonth, month = date.monthValue, year = date.year
        )

        // emit local fixtures
        emit(Resource.Success(data = localFixtures.map { it.toModel() }))
        Timber.i("Emitted Local Fixtures are: $localFixtures")
        // decide if local cache will suffice

        val useLocalCache = localFixtures.isNotEmpty() && !isRefresh
        emit(Resource.Success(data = localFixtures.map { it.toModel() }))
        if (useLocalCache) {

            // stop loading
            emit(Resource.Loading(isLoading = false))

            // return control
            return@flow
        }

        // past this point proceed with the API Call

        val remoteFixtures = try {

            api.getFixturesByDate(date.toStringDate())
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

        // vet and insert remote date into database
        remoteFixtures?.let { response ->
            //clear old data
            dao.clearFixtures()
            val fixtures = response.response

            //insert new data
            dao.insertFixtures(fixtures.map { it.toEntity() })
        }

        // read from single source of truth and emit
        val updatedLocalFixtures = dao.getFixturesByDate(
            dayOfMonth = date.dayOfMonth,
            month = date.monthValue,
            year = date.year
        )

        // emit updatedLocalFixtures

        emit(Resource.Success(data = updatedLocalFixtures.map { it.toModel() }))

        // discontinue loading
        emit(Resource.Loading(isLoading = false))
    }
}
