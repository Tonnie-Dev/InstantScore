package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class Parameters(
    @Json(name = "date")
    val date: String
)