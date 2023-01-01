package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.utils.*
import retrofit2.http.GET
import retrofit2.http.Query
import java.time.LocalDate

interface ScoresAPI {

    @GET(GET_FIXTURES)
    suspend fun getFixturesByDate(
        @Query("date")
        date: String = LocalDate.now()
            .toStringDate()
    ): com.uxstate.instantscore.data.remote.dtos.fixtures_by_date.FixturesResponseDTO




}