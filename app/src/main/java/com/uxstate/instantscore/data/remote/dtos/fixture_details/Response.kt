package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Response(
    @Json(name = "events")
    val events: List<Event>,
    @Json(name = "fixture")
    val fixture: Fixture,
    @Json(name = "goals")
    val goals: Goals,
    @Json(name = "league")
    val league: League,
    @Json(name = "lineups")
    val lineups: List<Lineup>,
    @Json(name = "players")
    val players: List<PlayerXXXX>,
    @Json(name = "score")
    val score: Score,
    @Json(name = "statistics")
    val statistics: List<StatisticX>,
    @Json(name = "teams")
    val teams: Teams
)