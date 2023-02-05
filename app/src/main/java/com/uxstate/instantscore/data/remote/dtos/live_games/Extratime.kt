package com.uxstate.instantscore.data.remote.dtos.live_games


import com.squareup.moshi.Json

data class Extratime(
    @Json(name = "away")
    val away: Any,
    @Json(name = "home")
    val home: Any
)