package com.uxstate.instantscore.data.repository

import com.uxstate.instantscore.domain.models.fixtures.Fixture
import com.uxstate.instantscore.domain.repository.ScoreRepository
import kotlinx.coroutines.flow.Flow

class ScoreRepositoryImpl : ScoreRepository{
    override fun getFixtures(isRefresh: Boolean): Flow<List<Fixture>> {
        TODO("Not yet implemented")
    }
}