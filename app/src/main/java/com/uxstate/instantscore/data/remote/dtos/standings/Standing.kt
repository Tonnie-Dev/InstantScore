package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Standing(
    @Json(name = "all")
    val all: All,
    @Json(name = "away")
    val away: Away,
    @Json(name = "description")
    val description: String,
    @Json(name = "form")
    val form: String,
    @Json(name = "goalsDiff")
    val goalsDiff: Int,
    @Json(name = "group")
    val group: String,
    @Json(name = "home")
    val home: Home,
    @Json(name = "points")
    val points: Int,
    @Json(name = "rank")
    val rank: Int,
    @Json(name = "status")
    val status: String,
    @Json(name = "team")
    val team: Team,
    @Json(name = "update")
    val update: String
)