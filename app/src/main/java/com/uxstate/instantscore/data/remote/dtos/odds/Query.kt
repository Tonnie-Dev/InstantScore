package com.uxstate.instantscore.data.remote.dtos.odds

import com.squareup.moshi.Json

data class Query(
    @Json(name = "apikey")
    val apikey: String
)