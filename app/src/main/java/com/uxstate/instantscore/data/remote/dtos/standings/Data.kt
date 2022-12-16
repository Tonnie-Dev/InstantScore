package com.uxstate.instantscore.data.remote.dtos.standings


import com.squareup.moshi.Json

data class Data(
    @Json(name = "has_groups")
    val hasGroups: Int,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "standings")
    val standings: List<Standing>
)