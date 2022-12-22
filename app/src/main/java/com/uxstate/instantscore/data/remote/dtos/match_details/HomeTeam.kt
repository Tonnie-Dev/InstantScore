package com.uxstate.instantscore.data.remote.dtos.match_details

import com.squareup.moshi.Json

data class HomeTeam(
    @Json(name = "country")
    val country: Country,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "short_code")
    val shortCode: String,
    @Json(name = "team_id")
    val teamId: Int
)