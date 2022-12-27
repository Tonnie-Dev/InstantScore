package com.uxstate.instantscore.data.remote.api

import com.uxstate.instantscore.data.remote.dtos.fixture_details.FixtureDetailsResponseDTO
import com.uxstate.instantscore.data.remote.dtos.fixtures.FixturesResponseDTO
import com.uxstate.instantscore.data.remote.dtos.leagues.LeagueResponseDTO
import com.uxstate.instantscore.utils.*
import retrofit2.http.GET
import retrofit2.http.Query

interface ScoresAPI {
    @GET(GET_LEAGUES_BY_ID)
    suspend fun getLeagueById(
        @Query("id") leagueId: Int = DEFAULT_LEAGUE_ID,
        @Query("season") seasonYear: Int = DEFAULT_SEASON
    ): LeagueResponseDTO

    @GET(GET_FIXTURES)
    suspend fun getFixturesByLeague(
        @Query("league") leagueId: Int = DEFAULT_LEAGUE_ID,
        @Query("season") seasonYear: Int = DEFAULT_SEASON
    ): FixturesResponseDTO

    @GET(GET_FIXTURES)
    suspend fun getFixtureDetails(

        @Query("id") fixtureId: Int = DEFAULT_FIXTURE_ID
    ): FixtureDetailsResponseDTO

  /*  @GET(GET_STANDINGS)
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
    )*/
}