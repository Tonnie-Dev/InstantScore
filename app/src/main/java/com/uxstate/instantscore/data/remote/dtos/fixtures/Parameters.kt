package com.uxstate.instantscore.data.remote.dtos.fixtures

import com.squareup.moshi.Json

data class Parameters(
    @Json(name = "league")
    val league: String,
    @Json(name = "season")
    val season: String
)