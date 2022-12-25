package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class PlayerXX(
    @Json(name = "grid")
    val grid: Any?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: Int,
    @Json(name = "pos")
    val pos: String
)