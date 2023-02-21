package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class Away(
    @Json(name = "id")
    val id: Int,
    @Json(name = "logo")
    val logo: String,
    @Json(name = "playerName")
    val name: String,
    @Json(name = "winner")
    val winner: Boolean?
)