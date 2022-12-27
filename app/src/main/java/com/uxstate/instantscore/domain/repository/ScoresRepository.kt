package com.uxstate.instantscore.domain.repository

import com.uxstate.instantscore.data.remote.dtos.stackoverflow.NetworkIncome
import com.uxstate.instantscore.domain.models.fixtures.Fixture
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ScoresRepository {

    fun getFixtures(isRefresh: Boolean): Flow<Resource<List<Fixture>>>
    fun getIncome(): Flow<Resource<List<NetworkIncome>>>
}