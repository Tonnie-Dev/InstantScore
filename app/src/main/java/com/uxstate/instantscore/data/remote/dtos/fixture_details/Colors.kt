package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Colors(
    @Json(name = "goalkeeper")
    val goalkeeper: Goalkeeper,
    @Json(name = "player")
    val player: PlayerXXX
)