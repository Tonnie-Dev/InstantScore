package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.data.local.ScoresDatabase
import com.uxstate.instantscore.data.remote.api.ScoresAPI
import com.uxstate.instantscore.data.remote.mappers.toEntity
import com.uxstate.instantscore.data.remote.mappers.toModel
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import java.io.IOException
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.time.LocalDate

class ScoresRepositoryImpl @Inject constructor(
    private val api: ScoresAPI,
    private val db: ScoresDatabase
) :
    ScoresRepository {
    private val dao = db.dao
    override fun getFixtures(isRefresh: Boolean): Flow<Resource<List<FixtureBonoko>>> = flow {

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

    override fun getFixturesForDate(
        isRefresh: Boolean,
        date: LocalDate
    ): Flow<Resource<List<FixtureBonoko>>> {
        TODO("Not yet implemented")
    }
}