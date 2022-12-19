package com.uxstate.instantscore.data.remote.dtos.matches


import com.squareup.moshi.Json

data class Query(
    @Json(name = "apikey")
    val apikey: String,
    @Json(name = "date_from")
    val dateFrom: String,
    @Json(name = "season_id")
    val seasonId: String
)