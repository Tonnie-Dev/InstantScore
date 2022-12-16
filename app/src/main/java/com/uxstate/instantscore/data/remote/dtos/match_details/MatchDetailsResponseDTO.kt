package com.uxstate.instantscore.data.remote.dtos.match_details


import com.squareup.moshi.Json

data class MatchDetailsResponseDTO(
    @Json(name = "data")
    val data: Data,
    @Json(name = "query")
    val query: Query
)