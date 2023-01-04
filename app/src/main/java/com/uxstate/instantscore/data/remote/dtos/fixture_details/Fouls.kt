package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Fouls(
    @Json(name = "committed")
    val committed: Int?,
    @Json(name = "drawn")
    val drawn: Int?
)