package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class TeamX(
    @Json(name = "colors")
    val colors: Colors,
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String
)