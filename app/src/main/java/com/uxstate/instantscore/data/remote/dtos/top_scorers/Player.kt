package com.uxstate.instantscore.data.remote.dtos.top_scorers

import com.squareup.moshi.Json

data class Player(
    @Json(name = "player_id")
    val playerId: Int,
    @Json(name = "player_name")
    val playerName: String
)