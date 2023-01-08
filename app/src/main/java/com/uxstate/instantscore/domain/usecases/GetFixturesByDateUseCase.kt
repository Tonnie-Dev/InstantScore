package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber

class GetFixturesByDateUseCase(private val repository: ScoresRepository) {

    operator fun invoke(isRefresh: Boolean, date: LocalDate): Flow<Resource<List<Fixture>>> {

        return repository.getFixturesByDate(isRefresh = isRefresh, date = date)
    }
}