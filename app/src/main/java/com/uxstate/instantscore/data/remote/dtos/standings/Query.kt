package com.uxstate.instantscore.data.remote.dtos.standings


import com.squareup.moshi.Json

data class Query(
    @Json(name = "apikey")
    val apikey: String,
    @Json(name = "season_id")
    val seasonId: String
)