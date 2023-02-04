package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.navArgs
import com.uxstate.instantscore.presentation.screens.standings_screen.state.StandingsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer,
    private val handle: SavedStateHandle
) :
    ViewModel() {

    private val _standingsState = MutableStateFlow(StandingsState())
    val standingsState = _standingsState.asStateFlow()

    // use generated extension function on the handle
    val leagueId = handle.navArgs<LeagueNavArgumentsHolder>().id
}