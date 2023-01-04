package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Lineup(
    @Json(name = "coach")
    val coach: Coach,
    @Json(name = "formation")
    val formation: String,
    @Json(name = "startXI")
    val startXI: List<StartXI>,
    @Json(name = "substitutes")
    val substitutes: List<Substitute>,
    @Json(name = "team")
    val team: TeamX
)