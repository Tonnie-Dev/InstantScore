package com.uxstate.instantscore.presentation.screens.home_screen.state

import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko

data class FixturesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val fixturesData: List<FixtureBonoko> = listOf()
)
