package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Dribbles(
    @Json(name = "attempts")
    val attempts: Int?,
    @Json(name = "past")
    val past: Int?,
    @Json(name = "success")
    val success: Int?
)