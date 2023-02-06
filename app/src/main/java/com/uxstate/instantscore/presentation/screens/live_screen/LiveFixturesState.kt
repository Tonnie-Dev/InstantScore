package com.uxstate.instantscore.presentation.screens.live_screen

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League

data class LiveFixturesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val fixturesMap: Map<League, List<Fixture>> = emptyMap()
)
