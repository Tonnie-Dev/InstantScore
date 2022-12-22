package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class StatisticXX(
    @Json(name = "type")
    val type: String,
    @Json(name = "value")
    val value: Int?
)