package com.uxstate.instantscore.domain.models.fixtures

data class Stats(
    val shotsOnGoal: Int,
    val shotsOffGoal: Int,
    val totalShots: Int,
    val fouls: Int,
    val cornerKicks: Int,
    val offSides: Int,
    val possession: Int,
    val redCards: Int,
    val yellowCards: Int
)
