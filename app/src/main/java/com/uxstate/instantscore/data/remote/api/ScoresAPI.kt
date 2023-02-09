package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.data.remote.dtos.fixtures_by_date.FixturesResponseDTO
import com.uxstate.instantscore.data.remote.dtos.top_scorer.TopScorerResponseDto
import com.uxstate.instantscore.utils.*
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface ScoresAPI {

    @GET(GET_FIXTURES)
    suspend fun getFixturesByDate(
        @Query("date")
        date: String = LocalDate.now()
            .toReverseStringDate()
    ): FixturesResponseDTO

    @GET(GET_FIXTURES)
    suspend fun getFixtureDetails(@Query("id") fixtureId: Int): String

    @GET(GET_STANDINGS)
    suspend fun getStandings(
        @Query("season") season: Int,
        @Query("league") leagueId: Int
    ): String

    @GET(GET_LIVE_FIXTURES)
    suspend fun getLiveFixtures(@Query("live") live: String = "all"): String

    @GET(GET_TOP_SCORERS)
    suspend fun getTopScorers(
        @Query("league") leagueId: Int,
        @Query("season") season: Int,
    ): TopScorerResponseDto
}