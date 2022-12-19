package com.uxstate.instantscore.data.remote.dtos.top_scorers

import com.squareup.moshi.Json

data class TopScorersResponseDTO(
    @Json(name = "data")
    val data: List<Data>,
    @Json(name = "query")
    val query: Query
)