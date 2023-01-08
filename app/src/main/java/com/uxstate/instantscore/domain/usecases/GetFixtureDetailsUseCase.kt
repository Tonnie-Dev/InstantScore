package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetFixtureDetailsUseCase(private val repository: ScoresRepository) {

    operator fun invoke(fixtureId: Int): Flow<Resource<FixtureDetails>> {

        return repository.getFixtureDetails(fixtureId = fixtureId)
    }
}