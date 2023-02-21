package com.uxstate.instantscore.domain.models.player_stats

data class PlayerStats(
    val rank:Int,
    val playerName: String,
    val playerPhoto: String,
    val teamName: String,
    val teamLogo: String,
    val goals: Int,
    val assists: Int,
    val yellowCards: Int,
    val redCards: Int
)
