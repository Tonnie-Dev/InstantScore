package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetLiveFixturesUseCase (private val repository: ScoresRepository) {
    operator fun invoke(): Flow<Resource<Map<League, List<Fixture>>>> {

        return repository.getLiveFixtures()
    }
}