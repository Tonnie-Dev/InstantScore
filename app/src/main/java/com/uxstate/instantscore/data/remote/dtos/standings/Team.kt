package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Team(
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String
)