package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date


import com.squareup.moshi.Json

data class Teams(
    @Json(name = "away")
    val away: Away,
    @Json(name = "home")
    val home: Home
)