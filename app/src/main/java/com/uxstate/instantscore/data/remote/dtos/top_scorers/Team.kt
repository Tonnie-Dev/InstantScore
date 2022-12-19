package com.uxstate.instantscore.data.remote.dtos.top_scorers

import com.squareup.moshi.Json

data class Team(
    @Json(name = "team_id")
    val teamId: Int,
    @Json(name = "team_name")
    val teamName: String
)