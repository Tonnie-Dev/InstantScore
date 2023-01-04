package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Cards(
    @Json(name = "red")
    val red: Int,
    @Json(name = "yellow")
    val yellow: Int
)