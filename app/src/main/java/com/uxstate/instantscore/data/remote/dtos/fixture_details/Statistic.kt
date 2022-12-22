package com.uxstate.instantscore.data.remote.dtos.fixture_details


import com.squareup.moshi.Json

data class Statistic(
    @Json(name = "cards")
    val cards: Cards,
    @Json(name = "dribbles")
    val dribbles: Dribbles,
    @Json(name = "duels")
    val duels: Duels,
    @Json(name = "fouls")
    val fouls: Fouls,
    @Json(name = "games")
    val games: Games,
    @Json(name = "goals")
    val goals: GoalsX,
    @Json(name = "offsides")
    val offsides: Int?,
    @Json(name = "passes")
    val passes: Passes,
    @Json(name = "penalty")
    val penalty: Penalty,
    @Json(name = "shots")
    val shots: Shots,
    @Json(name = "tackles")
    val tackles: Tackles
)