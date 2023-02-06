package com.uxstate.instantscore.presentation.screens.live_screen

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture

data class LiveFixturesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val fixtures: List<Fixture> = emptyList()
)
