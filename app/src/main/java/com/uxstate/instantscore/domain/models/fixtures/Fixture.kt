package com.uxstate.instantscore.domain.models.fixtures

data class Fixture(
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val teams: Pair<Team, Team>
)
