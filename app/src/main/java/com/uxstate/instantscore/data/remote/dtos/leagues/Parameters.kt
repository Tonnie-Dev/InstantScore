package com.uxstate.instantscore.data.remote.dtos.leagues


import com.squareup.moshi.Json

data class Parameters(
    @Json(name = "id")
    val id: String
)