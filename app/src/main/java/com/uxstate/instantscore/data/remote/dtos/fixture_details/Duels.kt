package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Duels(
    @Json(name = "total")
    val total: Int?,
    @Json(name = "won")
    val won: Int?
)