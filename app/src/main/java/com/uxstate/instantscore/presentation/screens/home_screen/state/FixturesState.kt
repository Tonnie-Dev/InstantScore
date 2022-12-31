package com.uxstate.instantscore.presentation.screens.home_screen.state

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import java.time.LocalDate

data class FixturesState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val fixtures: List<Fixture> = listOf(),
    val date: LocalDate = LocalDate.now()
)
