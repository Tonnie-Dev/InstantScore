package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Teams(
    @Json(name = "away")
    val away: Away,
    @Json(name = "home")
    val home: Home
)