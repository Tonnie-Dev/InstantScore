package com.uxstate.instantscore.data.remote.dtos.fixtures_by_date

import com.squareup.moshi.Json

data class ResponseDTO(
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