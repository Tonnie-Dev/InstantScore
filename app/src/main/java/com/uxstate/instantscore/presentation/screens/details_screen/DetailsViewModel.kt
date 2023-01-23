package com.uxstate.instantscore.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.details_screen.state.FixtureDetailsState
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class DetailsViewModel @Inject constructor(private val useCaseContainer: UseCaseContainer) :
    ViewModel() {
    private val _fakeState = MutableStateFlow(FixtureDetailsState())
    val fakeState = _fakeState.asStateFlow()

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {

        getFixtureDetails(fixtureId = 777)
    }

    private fun getFixtureDetails(fixtureId: Int) {
        Timber.i("getFixtureDetails invoked")
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
                        Timber.i("Loading status is ${result.isLoading}")
                        _fakeState.value = _fakeState.value.copy(isLoading = result.isLoading)
                    }
                    is Resource.Error -> {
                        // stop loading, set the ?data available in this case leave the default
                        // FixtureDetails ()item
                        Timber.i("Error Found ${result.errorMessage ?: "Unknown Error"}")
                        _fakeState.value = _fakeState.value.copy(isLoading = false)

                        // send ui event
                        sendUiEvent(
                            UIEvent.ShowSnackBarUiEvent(
                                message = result.errorMessage ?: "Unknown Error",
                                action = "OK"
                            )
                        )
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    private fun sendUiEvent(event: UIEvent) {
        Timber.i("sendUiEvent() invoked")
        viewModelScope.launch {

            _uiEvent.send(event)
        }
    }
}