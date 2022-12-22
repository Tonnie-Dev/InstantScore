package com.uxstate.instantscore.data.remote.dtos.leagues


import com.squareup.moshi.Json

data class Paging(
    @Json(name = "current")
    val current: Int,
    @Json(name = "total")
    val total: Int
)