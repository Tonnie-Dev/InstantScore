package com.uxstate.instantscore.presentation.screens.stats_screen

import com.uxstate.instantscore.domain.models.player_stats.PlayerStats

data class StatState(
    val stats: List<PlayerStats> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false
)