package com.uxstate.instantscore.data.remote.dtos.matches

import com.squareup.moshi.Json

data class X34(
    @Json(name = "away_team")
    val awayTeam: AwayTeam,
    @Json(name = "home_team")
    val homeTeam: HomeTeamXXXXXXXXXXXXXXXXXXXXXXXXXXX,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "match_id")
    val matchId: Int,
    @Json(name = "match_start")
    val matchStart: String,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "stats")
    val stats: StatsXXXXXXXXXXXXXXXXXXXXXXXXXXX,
    @Json(name = "status")
    val status: String,
    @Json(name = "status_code")
    val statusCode: Int,
    @Json(name = "venue")
    val venue: VenueXXXXXXXXXXXXXXXXXXXXXXXXXXX
)