package com.uxstate.instantscore.data.remote.dtos.leagues

import com.squareup.moshi.Json

data class Country(
    @Json(name = "code")
    val code: String,
    @Json(name = "flag")
    val flag: String,
    @Json(name = "name")
    val name: String
)