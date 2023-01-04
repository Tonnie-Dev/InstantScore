package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Tackles(
    @Json(name = "blocks")
    val blocks: Int?,
    @Json(name = "interceptions")
    val interceptions: Int?,
    @Json(name = "total")
    val total: Int?
)