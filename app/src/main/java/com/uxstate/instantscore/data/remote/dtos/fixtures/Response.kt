package com.uxstate.instantscore.data.remote.dtos.fixtures


import com.squareup.moshi.Json

data class Response(
    @Json(name = "fixture")
    val fixture: Fixture,
    @Json(name = "goals")
    val goals: Goals,
    @Json(name = "league")
    val league: League,
    @Json(name = "score")
    val score: Score,
    @Json(name = "teams")
    val teams: Teams
)