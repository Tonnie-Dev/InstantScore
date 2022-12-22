package com.uxstate.instantscore.domain.models.league

data class League(
    val leagueId: Int,
    val logo: String,
    val country: String,
    val seasons: List<Season>
)
