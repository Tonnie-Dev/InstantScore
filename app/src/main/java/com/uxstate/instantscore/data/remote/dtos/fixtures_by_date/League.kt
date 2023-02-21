package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class League(
    @Json(name = "country")
    val country: String,
    @Json(name = "flag")
    val flag: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "playerName")
    val name: String,
    @Json(name = "round")
    val round: String,
    @Json(name = "season")
    val season: Int
)