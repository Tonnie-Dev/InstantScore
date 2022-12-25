package com.uxstate.instantscore.presentation.screens.home_screen

import com.uxstate.instantscore.domain.models.fixtures.Fixture

data class FixturesState(
    val isLoading: Boolean = false,
    val error: String = "",
    val fixturesData: List<Fixture> = listOf()
)
