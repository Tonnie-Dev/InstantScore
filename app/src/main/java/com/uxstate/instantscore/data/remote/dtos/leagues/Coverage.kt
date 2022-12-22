package com.uxstate.instantscore.data.remote.dtos.leagues


import com.squareup.moshi.Json

data class Coverage(
    @Json(name = "fixtures")
    val fixtures: Fixtures,
    @Json(name = "injuries")
    val injuries: Boolean,
    @Json(name = "odds")
    val odds: Boolean,
    @Json(name = "players")
    val players: Boolean,
    @Json(name = "predictions")
    val predictions: Boolean,
    @Json(name = "standings")
    val standings: Boolean,
    @Json(name = "top_assists")
    val topAssists: Boolean,
    @Json(name = "top_cards")
    val topCards: Boolean,
    @Json(name = "top_scorers")
    val topScorers: Boolean
)