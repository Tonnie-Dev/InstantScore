package com.uxstate.instantscore.data.remote.dtos.matches


import com.squareup.moshi.Json

data class MatchesResponseDTO(
    @Json(name = "data")
    val `data`: List<Data>,
    @Json(name = "query")
    val query: Query
)