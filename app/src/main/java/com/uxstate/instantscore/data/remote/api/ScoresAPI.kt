package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.data.remote.dtos.match_details.MatchDetailsResponseDTO
import com.uxstate.instantscore.data.remote.dtos.standings.StandingResponseDTO
import com.uxstate.instantscore.utils.API_KEY_1
import com.uxstate.instantscore.utils.DEFAULT_LEAGUE_ID
import com.uxstate.instantscore.utils.GET_MATCH_DETAILS
import com.uxstate.instantscore.utils.GET_STANDINGS
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScoresAPI {

    @GET(GET_MATCH_DETAILS)

    suspend fun getMatchDetails(
        @Path("id") id: String,
        @Query("apikey") apiKey: String = API_KEY_1
    ): MatchDetailsResponseDTO

    @GET(GET_STANDINGS)
    suspend fun getStandings(
        @Query("apikey") apiKey: String = API_KEY_1,
        @Query("season_id") seasonId: String = DEFAULT_LEAGUE_ID
    ): StandingResponseDTO
}