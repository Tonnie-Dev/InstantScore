package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class PlayerXXXXX(
    @Json(name = "player")
    val player: PlayerXXXXXX,
    @Json(name = "statistics")
    val statistics: List<Statistic>
)