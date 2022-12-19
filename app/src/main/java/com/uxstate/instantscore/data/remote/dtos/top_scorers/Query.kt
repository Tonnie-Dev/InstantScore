package com.uxstate.instantscore.data.remote.dtos.top_scorers


import com.squareup.moshi.Json

data class Query(
    @Json(name = "apikey")
    val apikey: String
)