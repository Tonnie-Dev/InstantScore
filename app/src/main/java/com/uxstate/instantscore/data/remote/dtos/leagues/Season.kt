package com.uxstate.instantscore.data.remote.dtos.leagues

import com.squareup.moshi.Json

data class Season(
    @Json(name = "coverage")
    val coverage: Coverage,
    @Json(name = "current")
    val current: Boolean,
    @Json(name = "end")
    val end: String,
    @Json(name = "start")
    val start: String,
    @Json(name = "year")
    val year: Int
)