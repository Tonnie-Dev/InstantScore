package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Event(
    @Json(name = "assist")
    val assist: Assist,
    @Json(name = "comments")
    val comments: String?,
    @Json(name = "detail")
    val detail: String,
    @Json(name = "player")
    val player: Player,
    @Json(name = "team")
    val team: Team,
    @Json(name = "time")
    val time: Time,
    @Json(name = "type")
    val type: String
)