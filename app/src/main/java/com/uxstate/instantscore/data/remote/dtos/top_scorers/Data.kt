package com.uxstate.instantscore.data.remote.dtos.top_scorers


import com.squareup.moshi.Json

data class Data(
    @Json(name = "goals")
    val goals: Goals,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "matches_played")
    val matchesPlayed: Int,
    @Json(name = "minutes_played")
    val minutesPlayed: Int,
    @Json(name = "penalties")
    val penalties: Int?,
    @Json(name = "player")
    val player: Player,
    @Json(name = "pos")
    val pos: Int,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "substituted_in")
    val substitutedIn: Int?,
    @Json(name = "team")
    val team: Team
)