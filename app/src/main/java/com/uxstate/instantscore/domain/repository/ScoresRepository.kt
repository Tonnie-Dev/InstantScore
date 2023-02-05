package com.uxstate.instantscore.domain.repository

import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.utils.Resource
import java.time.LocalDate
import kotlinx.coroutines.flow.Flow

interface ScoresRepository {

    fun getFixturesByDate(
        isRefresh: Boolean,
        date: LocalDate
    ): Flow<Resource<Map<League, List<Fixture>>>>

    fun getFixtureDetails(fixtureId: Int): Flow<Resource<FixtureDetails>>

    fun getStandings(season: Int, leagueId: Int): Flow<Resource<MutableList<Standing>>>


    fun getLiveFixtures(): Flow<Resource<Map<League, List<Fixture>>>>
}