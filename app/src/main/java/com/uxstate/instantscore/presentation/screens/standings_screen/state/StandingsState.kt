package com.uxstate.instantscore.presentation.screens.standings_screen.state

import com.uxstate.instantscore.domain.models.standings.Standing

data class StandingsState(
    val standingsList: List<Standing> = emptyList(),
    val isLoading: Boolean = false,
    val errorMessage: String = ""
)
