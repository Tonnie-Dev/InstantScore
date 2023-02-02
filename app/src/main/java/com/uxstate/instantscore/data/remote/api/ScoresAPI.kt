package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.data.remote.dtos.fixtures_by_date.FixturesResponseDTO
import com.uxstate.instantscore.utils.*
import java.time.LocalDate
import retrofit2.http.GET
import retrofit2.http.Query

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
    ):String
}