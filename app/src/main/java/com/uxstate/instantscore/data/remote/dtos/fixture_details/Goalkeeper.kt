package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Goalkeeper(
    @Json(name = "border")
    val border: String,
    @Json(name = "number")
    val number: String,
    @Json(name = "primary")
    val primary: String
)