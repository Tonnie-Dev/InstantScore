package com.uxstate.instantscore.domain.repository

import com.uxstate.instantscore.domain.models.fixtures.Fixture
import kotlinx.coroutines.flow.Flow

interface ScoreRepository {

    fun getFixtures(isRefresh:Boolean):Flow<List<Fixture>>
}