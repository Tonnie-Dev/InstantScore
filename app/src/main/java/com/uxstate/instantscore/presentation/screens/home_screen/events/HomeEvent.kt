package com.uxstate.instantscore.presentation.screens.home_screen.events

import java.time.LocalDate

sealed class HomeEvent {
    data class OnRefresh(val isRefresh: Boolean) : HomeEvent()
    data class OnFixtureDateSelection(val date: LocalDate) : HomeEvent()
    data class CalendarDateSelection(val date: LocalDate) : HomeEvent()
}
