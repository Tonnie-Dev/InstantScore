package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class GoalsX(
    @Json(name = "assists")
    val assists: Int?,
    @Json(name = "conceded")
    val conceded: Int,
    @Json(name = "saves")
    val saves: Int?,
    @Json(name = "total")
    val total: Int?
)