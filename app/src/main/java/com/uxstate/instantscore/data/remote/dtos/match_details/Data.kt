package com.uxstate.instantscore.data.remote.dtos.match_details


import com.squareup.moshi.Json

data class Data(
    @Json(name = "away_team")
    val awayTeam: AwayTeam,
    @Json(name = "home_team")
    val homeTeam: HomeTeam,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "lineups")
    val lineups: List<Lineup>,
    @Json(name = "match_id")
    val matchId: Int,
    @Json(name = "match_start")
    val matchStart: String,
    @Json(name = "match_statistics")
    val matchStatistics: Any?,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "stats")
    val stats: Stats,
    @Json(name = "status")
    val status: String,
    @Json(name = "status_code")
    val statusCode: Int,
    @Json(name = "venue")
    val venue: Venue
)