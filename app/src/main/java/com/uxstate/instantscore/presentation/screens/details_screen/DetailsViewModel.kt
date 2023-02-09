package com.uxstate.instantscore.presentation.screens.details_screen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.details_screen.state.FixtureDetailsState
import com.uxstate.instantscore.presentation.screens.navArgs
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer,
    handle: SavedStateHandle
) : ViewModel() {

    private val navArgs = handle.navArgs<DetailsScreenNavArgs>()

    private val _fakeState = MutableStateFlow(FixtureDetailsState())
    val fakeState = _fakeState.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {

        getFixtureDetails(fixtureId = navArgs.id)
        Timber.i("The id is: ${navArgs.id}")
    }

    private fun getFixtureDetails(fixtureId: Int) {

        useCaseContainer.getFixtureDetailsUseCase(fixtureId)
            .onEach { result ->

                when (result) {

                    is Resource.Success -> {

                        result.data?.let {

                            _fakeState.value = _fakeState.value.copy(fixtureDetails = it)
                        }
                        Timber.i("Success")
                    }
                    is Resource.Loading -> {

                        _fakeState.value = _fakeState.value.copy(isLoading = result.isLoading)
                    }
                    is Resource.Error -> {
                        // stop loading, set the ?data available in this case leave the default
                        // FixtureDetails ()item

                        _fakeState.value = _fakeState.value.copy(isLoading = false)

                        // send ui event
                        sendUiEvent(
                            UIEvent.ShowSnackBarUiEvent(
                                message = result.errorMessage ?: "Unknown Error",
                                action = "OK"
                            )
                        )
                    }

                    else -> {}
                }
            }
            .launchIn(viewModelScope)
    }

    private fun sendUiEvent(event: UIEvent) {

        viewModelScope.launch {

            _uiEvent.send(event)
        }
    }
}