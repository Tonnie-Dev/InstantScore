package com.uxstate.instantscore.data.remote.dtos.matches


import com.squareup.moshi.Json

data class Round(
    @Json(name = "is_current")
    val isCurrent: Int?,
    @Json(name = "name")
    val name: String,
    @Json(name = "round_id")
    val roundId: Int
)