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
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber

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
    private val season = handle.navArgs<LeagueNavArgumentsHolder>().season
    private val leagueId = handle.navArgs<LeagueNavArgumentsHolder>().id

    init {
        Timber.i("The season is: $season, leagueId is: $leagueId")
        getStandings()
    }

    private fun getStandings() {

        useCaseContainer.getStandingsUseCase(season = season, leagueId = leagueId)
            .onEach { result ->
                when (result) {

                    is Resource.Success -> {

                        result.data?.let {
                            _standingsState.value =
                                _standingsState.value.copy(standingsList = it)
                        }
                    }

                    is Resource.Error -> {

                        // stop loading
                        // set whatever data is available, if null return an empty list

                        _standingsState.value = _standingsState.value.copy(
                            standingsList = result.data ?: emptyList(),
                            isLoading = false
                        )

                        sendUIEvent(
                            uiEvent = UIEvent.ShowSnackBarUiEvent(
                                message = result.errorMessage ?: "",
                                action = "Unknown Error"
                            )
                        )
                    }

                    is Resource.Loading -> {

                        _standingsState.value =
                            _standingsState.value.copy(isLoading = result.isLoading)
                    }

                    else -> {}
                }
            }
            .launchIn(viewModelScope)
    }

    private fun sendUIEvent(uiEvent: UIEvent) {

        viewModelScope.launch {

            _uiEvent.send(uiEvent)
        }
    }
}

fun transformKeysAndValues() {

    val planetsMap = mapOf(
        "p" to "pluto",
        "e" to "earth",
        "n" to "neptune"
    )

    // append toMap() call convert list pairs to a map
    val transformedMap = planetsMap.map {
        it.key.uppercase() to it.value.replaceFirstChar(Char::titlecase)
    }
        .toMap()

    println(transformedMap) // {P=Pluto, E=Earth, N=Neptune}
}
