package com.uxstate.instantscore.data.remote.dtos.matches

import com.squareup.moshi.Json

data class X27(
    @Json(name = "away_team")
    val awayTeam: AwayTeam,
    @Json(name = "home_team")
    val homeTeam: HomeTeamXXXXXXXXXXXXXXXXXXX,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "match_id")
    val matchId: Int,
    @Json(name = "match_start")
    val matchStart: String,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "stats")
    val stats: StatsXXXXXXXXXXXXXXXXXXX,
    @Json(name = "status")
    val status: String,
    @Json(name = "status_code")
    val statusCode: Int,
    @Json(name = "venue")
    val venue: VenueXXXXXXXXXXXXXXXXXXX
)