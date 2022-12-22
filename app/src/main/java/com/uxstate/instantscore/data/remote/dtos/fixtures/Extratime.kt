package com.uxstate.instantscore.data.remote.dtos.fixtures


import com.squareup.moshi.Json

data class Extratime(
    @Json(name = "away")
    val away: Any?,
    @Json(name = "home")
    val home: Any?
)