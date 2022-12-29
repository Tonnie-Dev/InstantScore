package com.uxstate.instantscore.presentation.screens.home_screen.events

sealed class HomeEvent {
    object OnRefresh : HomeEvent()
    data class OnFixtureDateSelection(val date: String) : HomeEvent()
}
