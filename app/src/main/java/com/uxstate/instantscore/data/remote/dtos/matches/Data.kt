package com.uxstate.instantscore.data.remote.dtos.matches

import com.squareup.moshi.Json

data class Data(
    @Json(name = "away_team")
    val awayTeam: AwayTeam,
    @Json(name = "group")
    val group: Group?,
    @Json(name = "home_team")
    val homeTeam: HomeTeam,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "match_id")
    val matchId: Int,
    @Json(name = "match_start")
    val matchStart: String,
    @Json(name = "match_start_iso")
    val matchStartIso: String,
    @Json(name = "minute")
    val minute: Int?,
    @Json(name = "referee_id")
    val refereeId: Int?,
    @Json(name = "round")
    val round: Round,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "stage")
    val stage: Stage,
    @Json(name = "stats")
    val stats: Stats,
    @Json(name = "status")
    val status: String,
    @Json(name = "status_code")
    val statusCode: Int,
    @Json(name = "venue")
    val venue: Venue?
)