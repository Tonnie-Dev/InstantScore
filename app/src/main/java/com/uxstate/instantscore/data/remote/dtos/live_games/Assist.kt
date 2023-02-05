package com.uxstate.instantscore.data.remote.dtos.live_games


import com.squareup.moshi.Json

data class Assist(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)