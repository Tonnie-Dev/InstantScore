package com.uxstate.instantscore.data.remote.dtos.odds


import com.squareup.moshi.Json

data class OddsResponseDTO(
    @Json(name = "data")
    val `data`: Data,
    @Json(name = "query")
    val query: Query
)