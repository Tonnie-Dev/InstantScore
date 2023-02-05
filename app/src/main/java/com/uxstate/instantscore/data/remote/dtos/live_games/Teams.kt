package com.uxstate.instantscore.data.remote.dtos.live_games


import com.squareup.moshi.Json

data class Teams(
    @Json(name = "away")
    val away: Away,
    @Json(name = "home")
    val home: Home
)