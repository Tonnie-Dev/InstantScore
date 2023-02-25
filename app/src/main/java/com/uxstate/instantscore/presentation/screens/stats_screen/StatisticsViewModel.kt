package com.uxstate.instantscore.presentation.screens.stats_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.navArgs
import com.uxstate.instantscore.presentation.screens.stats_screen.events.StatsEvent
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer,
    private val handle: SavedStateHandle
) : ViewModel() {

    val navArgs = handle.navArgs<statsNavArgs>()
    private val _state = MutableStateFlow(StatState())
    val state = _state.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {

        getStats(
            statType = navArgs.statType
        )
    }

    private fun getStats(statType: String) {

        useCaseContainer.getStatsUseCase(
            statType = statType,
            leagueId = navArgs.leagueId,
            season = navArgs.season
        )
            .onEach {

                result ->

                when (result) {

                    is Resource.Success -> {

                        result.data?.let {

                            _state.value = _state.value.copy(stats = it)
                        }
                    }
                    is Resource.Error -> {

                        _state.value = _state.value.copy(
                            isLoading = false,
                            stats = result.data ?: emptyList()
                        )

                        sendUIEvent(
                            UIEvent.ShowSnackBarUiEvent(
                                message = result.errorMessage ?: "Unknown Error",
                                action = "OK"
                            )
                        )
                    }
                    is Resource.Loading -> {

                        _state.value = _state.value.copy(isLoading = result.isLoading)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun sendUIEvent(uiEvent: UIEvent) {

        viewModelScope.launch {

            _uiEvent.send(uiEvent)
        }
    }

    fun onEvent(event: StatsEvent) {

        when (event) {

            is StatsEvent.OnChipClick -> {
                getStats(event.statType)
            }
        }
    }
}