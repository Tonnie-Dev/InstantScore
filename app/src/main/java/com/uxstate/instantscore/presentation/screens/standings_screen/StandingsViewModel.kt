package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.navArgs
import com.uxstate.instantscore.presentation.screens.standings_screen.state.StandingsState
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer,
    private val handle: SavedStateHandle
) :
    ViewModel() {

    private val _standingsState = MutableStateFlow(StandingsState())
    val standingsState = _standingsState.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    // use generated extension function on the handle
    val leagueId = handle.navArgs<LeagueNavArgumentsHolder>().id

    private fun getStandings(leagueId: Int) {

        useCaseContainer.getStandingsUseCase(leagueId)
                .onEach { result ->
                    when (result) {

                        is Resource.Success -> {

                            result.data?.let {
                                _standingsState.value =
                                    _standingsState.value.copy(standingsList = it)
                            }
                        }
                        is Resource.Error -> {


                        }
                        is Resource.Loading -> {}
                    }
                }
    }


    private fun sendUIEvent(uiEvent:UIEvent){

        viewModelScope.launch {

            _uiEvent.send(uiEvent)
        }
    }
}