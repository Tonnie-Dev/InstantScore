package com.uxstate.instantscore.presentation.screens.home_screen.events

import java.time.LocalDate

sealed class HomeEvent {
    object OnRefresh : HomeEvent()
    data class OnFixtureDateSelection(val date: LocalDate) : HomeEvent()
}
