package com.uxstate.instantscore.data.remote.dtos.leagues


import com.squareup.moshi.Json

data class League(
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "type")
    val type: String
)