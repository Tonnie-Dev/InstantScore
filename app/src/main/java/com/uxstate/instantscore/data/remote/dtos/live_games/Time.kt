package com.uxstate.instantscore.data.remote.dtos.live_games

import com.squareup.moshi.Json

data class Time(
    @Json(name = "elapsed")
    val elapsed: Int,
    @Json(name = "extra")
    val extra: Int
)