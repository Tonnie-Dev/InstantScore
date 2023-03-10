package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class Fixture(
    @Json(name = "date")
    val date: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "periods")
    val periods: Periods,
    @Json(name = "referee")
    val referee: String?,
    @Json(name = "status")
    val status: Status,
    @Json(name = "timestamp")
    val timestamp: Long,
    @Json(name = "timezone")
    val timezone: String,
    @Json(name = "venue")
    val venue: Venue
)