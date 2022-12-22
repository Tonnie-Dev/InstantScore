package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Time(
    @Json(name = "elapsed")
    val elapsed: Int,
    @Json(name = "extra")
    val extra: Int?
)