package com.uxstate.instantscore.presentation.screens.home_screen.state

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import java.time.LocalDate

data class FixturesState(
    val isLoading: Boolean = false,
    val isRefresh: Boolean = false,
    val errorMessage: String = "",
    val fixtures: Map<League, List<Fixture>> = mapOf(),
    val date: LocalDate = LocalDate.now(),
    val isCalendarClicked: Boolean = false
)
