package com.uxstate.instantscore.data.remote.dtos.live_games

import com.squareup.moshi.Json

data class Response(
    @Json(name = "events")
    val events: List<Event?>?,
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