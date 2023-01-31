package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Goals(
    @Json(name = "against")
    val against: Int,
    @Json(name = "for")
    val forX: Int
)