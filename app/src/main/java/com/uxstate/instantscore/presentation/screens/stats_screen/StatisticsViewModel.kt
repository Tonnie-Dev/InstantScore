package com.uxstate.instantscore.presentation.screens.stats_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer
) : ViewModel() {

    private val _state = MutableStateFlow(StatState())
    val state = _state.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private fun getStats(leagueId: Int, season: Int, statType: String) {

        useCaseContainer.getStatsUseCase(leagueId = leagueId, season = season)
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
}