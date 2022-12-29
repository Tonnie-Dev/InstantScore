package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class FixturesResponseDTO(
    @Json(name = "errors")
    val errors: List<Any>,
    @Json(name = "get")
    val get: String,
    @Json(name = "paging")
    val paging: Paging,
    @Json(name = "parameters")
    val parameters: Parameters,
    @Json(name = "response")
    val response: List<ResponseDTO>,
    @Json(name = "results")
    val results: Int
)