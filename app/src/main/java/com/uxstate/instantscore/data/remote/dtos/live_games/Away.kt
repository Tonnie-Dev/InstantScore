package com.uxstate.instantscore.data.remote.dtos.live_games

import com.squareup.moshi.Json

data class Away(
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "winner")
    val winner: Boolean
)