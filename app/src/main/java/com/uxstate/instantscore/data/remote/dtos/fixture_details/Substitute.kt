package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Substitute(
    @Json(name = "player")
    val player: PlayerXX
)