package com.uxstate.instantscore.domain.models.fixtures

import com.uxstate.instantscore.data.remote.dtos.top_scorers.Team

data class FixtureDetails(
    val fixtureId: Int,
    val date: Long,
    val venue: String,
    val status: String,
    val timeElapsed: Int,
    val teams: Pair<Team, Team>,
    val events: List<Event>,
    val stats: Stats
)