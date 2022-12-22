package com.uxstate.instantscore.data.remote.dtos.leagues


import com.squareup.moshi.Json

data class Fixtures(
    @Json(name = "events")
    val events: Boolean,
    @Json(name = "lineups")
    val lineups: Boolean,
    @Json(name = "statistics_fixtures")
    val statisticsFixtures: Boolean,
    @Json(name = "statistics_players")
    val statisticsPlayers: Boolean
)