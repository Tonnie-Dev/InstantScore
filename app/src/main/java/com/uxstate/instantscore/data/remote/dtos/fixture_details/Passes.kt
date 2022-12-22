package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Passes(
    @Json(name = "accuracy")
    val accuracy: String?,
    @Json(name = "key")
    val key: Int?,
    @Json(name = "total")
    val total: Int?
)