package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Games(
    @Json(name = "captain")
    val captain: Boolean,
    @Json(name = "minutes")
    val minutes: Int?,
    @Json(name = "number")
    val number: Int,
    @Json(name = "position")
    val position: String,
    @Json(name = "rating")
    val rating: String?,
    @Json(name = "substitute")
    val substitute: Boolean
)