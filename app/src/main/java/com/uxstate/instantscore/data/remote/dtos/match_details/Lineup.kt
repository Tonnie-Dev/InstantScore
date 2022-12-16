package com.uxstate.instantscore.data.remote.dtos.match_details


import com.squareup.moshi.Json

data class Lineup(
    @Json(name = "formation")
    val formation: String,
    @Json(name = "formation_confirmed")
    val formationConfirmed: Int,
    @Json(name = "players")
    val players: List<Any>,
    @Json(name = "team_id")
    val teamId: Int
)