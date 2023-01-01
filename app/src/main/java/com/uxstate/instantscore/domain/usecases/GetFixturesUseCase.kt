package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetFixturesUseCase(private val repository: ScoresRepository) {

    operator fun invoke(isRefresh: Boolean): Flow<Resource<List<FixtureBonoko>>> {

        return repository.getFixtures(isRefresh = isRefresh)
    }
}