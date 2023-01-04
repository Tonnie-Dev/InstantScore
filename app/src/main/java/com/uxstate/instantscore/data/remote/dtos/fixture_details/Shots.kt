package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Shots(
    @Json(name = "on")
    val on: Int?,
    @Json(name = "total")
    val total: Int?
)