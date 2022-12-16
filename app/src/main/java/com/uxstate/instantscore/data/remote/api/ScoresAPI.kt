package com.uxstate.instantscore.data.remote.api

import android.provider.SyncStateContract
import com.uxstate.instantscore.data.remote.dtos.standings.StandingResponseDTO
import com.uxstate.instantscore.utils.API_KEY_1
import com.uxstate.instantscore.utils.DEFAULT_LEAGUE_ID
import com.uxstate.instantscore.utils.GET_STANDINGS
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.reflect.jvm.internal.impl.load.java.Constant

interface ScoresAPI {

    @GET(GET_STANDINGS)
    suspend fun getStandings(
        @Query("apikey") apiKey: String = API_KEY_1,
        @Query("season_id") seasonId: String = DEFAULT_LEAGUE_ID
    ): StandingResponseDTO
}