package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.data.remote.dtos.match_details.MatchDetailsResponseDTO
import com.uxstate.instantscore.data.remote.dtos.matches.MatchesResponseDTO
import com.uxstate.instantscore.data.remote.dtos.odds.OddsResponseDTO
import com.uxstate.instantscore.data.remote.dtos.standings.StandingResponseDTO
import com.uxstate.instantscore.utils.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ScoresAPI {

    @GET(GET_LEAGUES_BY_ID)
    suspend fun getLeagueById(@Query("id") leagueId:Int, @Query("season") seasonYear:Int)

    @GET(GET_MATCHES)
    suspend fun getFixtures(
        @Query("apikey") apiKey: String = API_KEY_1,
        @Query("season_id") seasonId: String = DEFAULT_SEASON_ID,
        @Query("date_from") dateFrom: String = DATE_FROM,
        @Query("date_to") dateTo: String = DATE_TO
    ): MatchesResponseDTO

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

    @GET(GET_ODDS)
    suspend fun getOdds(
        @Path("match_id") matchId: String,
        @Query("apikey") apiKey: String = API_KEY_1,
        @Query("type") type: String = ODDS_TYPE
    ): OddsResponseDTO

    @GET(GET_TOP_SCORERS)
    suspend fun getTopScorers(
        @Query("apikey") apiKey: String,
        @Query("season_id") seasonId: String
    )
}