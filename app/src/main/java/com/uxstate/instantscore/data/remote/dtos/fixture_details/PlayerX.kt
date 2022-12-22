package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class PlayerX(
    @Json(name = "grid")
    val grid: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "number")
    val number: Int,
    @Json(name = "pos")
    val pos: String
)