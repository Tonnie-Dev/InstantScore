package com.uxstate.instantscore.data.remote.dtos.match_details

import com.squareup.moshi.Json

data class Query(
    @Json(name = "apikey")
    val apikey: String
)