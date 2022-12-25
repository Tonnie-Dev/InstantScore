package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Goals(
    @Json(name = "away")
    val away: Int,
    @Json(name = "home")
    val home: Int
)