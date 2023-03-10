package com.uxstate.instantscore.data.remote.dtos.live_games

import com.squareup.moshi.Json

data class LiveFixturesResponseDTO(
    @Json(name = "errors")
    val errors: List<Any>,
    @Json(name = "get")
    val `get`: String,
    @Json(name = "paging")
    val paging: Paging,
    @Json(name = "parameters")
    val parameters: Parameters,
    @Json(name = "response")
    val response: List<Response>,
    @Json(name = "results")
    val results: Int
)