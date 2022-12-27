package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.dtos.stackoverflow.NetworkIncome
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.data.remote.mappers.toModel
import com.uxstate.instantscore.domain.models.fixtures.Fixture
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import timber.log.Timber

class ScoresRepositoryImpl @Inject constructor(
    private val api: ScoresAPI,
    private val db: ScoresDatabase
) :
    ScoresRepository {
    private val dao = db.dao
    override fun getFixtures(isRefresh: Boolean): Flow<Resource<List<Fixture>>> = flow {

        emit(Resource.Loading(isLoading = true))

        val localFixtures = dao.getFixtures()
        emit(Resource.Success(data = localFixtures.map { it.toModel() }))

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

            dao.insertFixtures(fixtures.map { it.toEntity() })
        }

        val updatedLocalCache = dao.getFixtures()

        emit(Resource.Success(data = updatedLocalCache.map { it.toModel() }))
        emit(Resource.Loading(isLoading = false))
    }

    override fun getIncome(): Flow<Resource<List<NetworkIncome>>> = flow {

        val response = try {
            api.getAllIncome()
        } catch (e: Exception) {

            e.printStackTrace()
            Timber.i("Funny Error ${e.message}")
            emit(Resource.Error(errorMessage = "Unknown error,  ${e.message}"))
            null
        }

        response?.let {
            Timber.i("Entering null Check")
            emit(Resource.Success(data = response))
        }
    }
}