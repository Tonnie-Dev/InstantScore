package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date


import com.squareup.moshi.Json

data class Periods(
    @Json(name = "first")
    val first: Int?,
    @Json(name = "second")
    val second: Int?
)