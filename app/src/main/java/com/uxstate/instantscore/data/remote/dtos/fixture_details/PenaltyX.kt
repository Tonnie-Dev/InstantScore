package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class PenaltyX(
    @Json(name = "away")
    val away: Any?,
    @Json(name = "home")
    val home: Any?
)