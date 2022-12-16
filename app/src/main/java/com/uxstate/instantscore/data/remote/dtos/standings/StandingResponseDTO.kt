package com.uxstate.instantscore.data.remote.dtos.standings


import com.squareup.moshi.Json

data class StandingResponseDTO(
    @Json(name = "data")
    val data: Data,
    @Json(name = "query")
    val query: Query
)