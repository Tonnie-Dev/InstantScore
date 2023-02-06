package com.uxstate.instantscore.presentation.screens.live_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LiveFixturesViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer
) : ViewModel() {


    private val _liveFixturesState = MutableStateFlow(LiveFixturesState())
    val liveFixturesState = _liveFixturesState.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getLiveFixtures()
    }

    private fun getLiveFixtures() {

        useCaseContainer.getLiveFixturesUseCase()
                .onEach {

                    result ->

                    when (result) {

                        is Resource.Success -> {

                            result.data?.let {

                                _liveFixturesState.value =
                                    _liveFixturesState.value.copy(fixturesMap = it)
                            }
                        }
                        is Resource.Error -> {

                            //stop loading and send and event to UI
                            _liveFixturesState.value =
                                _liveFixturesState.value.copy(
                                        isLoading = false,
                                        fixturesMap = result.data ?: emptyMap()
                                )


                            sendUIEvent(
                                    UIEvent.ShowSnackBarUiEvent(
                                            message = result.errorMessage ?: "Unknown Error",
                                            action = "OK"
                                    )
                            )


                        }
                        is Resource.Loading -> {

                            _liveFixturesState.value =
                                _liveFixturesState.value.copy(isLoading = result.isLoading)
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