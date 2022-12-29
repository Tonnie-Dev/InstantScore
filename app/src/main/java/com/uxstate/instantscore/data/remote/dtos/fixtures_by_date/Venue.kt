package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date


import com.squareup.moshi.Json

data class Venue(
    @Json(name = "city")
    val city: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?
)