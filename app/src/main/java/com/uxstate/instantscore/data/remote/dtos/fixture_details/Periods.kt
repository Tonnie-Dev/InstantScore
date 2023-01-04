package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Periods(
    @Json(name = "first")
    val first: Int,
    @Json(name = "second")
    val second: Int
)