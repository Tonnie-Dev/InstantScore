package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.navArgs
import com.uxstate.instantscore.presentation.screens.standings_screen.state.StandingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer,
    private val handle: SavedStateHandle
) :
    ViewModel() {

    val league = handle.navArgs<LeagueNavArgumentsHolder>()
    private val _standingsState = MutableStateFlow(StandingsState())
    val standingsState = _standingsState.asStateFlow()

}