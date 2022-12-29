package com.uxstate.instantscore.domain.repository

import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface ScoresRepository {

    fun getFixtures(isRefresh: Boolean): Flow<Resource<List<FixtureBonoko>>>
    fun getFixturesForDate(isRefresh: Boolean, date: LocalDate):Flow<Resource<List<Fixture>>>
}