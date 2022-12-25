package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Penalty(
    @Json(name = "commited")
    val commited: Any?,
    @Json(name = "missed")
    val missed: Int,
    @Json(name = "saved")
    val saved: Int?,
    @Json(name = "scored")
    val scored: Int,
    @Json(name = "won")
    val won: Any?
)