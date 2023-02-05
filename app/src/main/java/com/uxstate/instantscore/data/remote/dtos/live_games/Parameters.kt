package com.uxstate.instantscore.data.remote.dtos.live_games

import com.squareup.moshi.Json

data class Parameters(
    @Json(name = "live")
    val live: String
)