package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class PlayerXXXX(
    @Json(name = "players")
    val players: List<PlayerXXXXX>,
    @Json(name = "team")
    val team: TeamXX
)