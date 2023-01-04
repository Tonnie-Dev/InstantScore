package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class StatisticX(
    @Json(name = "statistics")
    val statistics: List<StatisticXX>,
    @Json(name = "team")
    val team: Team
)