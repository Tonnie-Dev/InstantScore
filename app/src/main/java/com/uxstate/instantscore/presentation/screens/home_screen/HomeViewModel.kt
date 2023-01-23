package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent.*
import com.uxstate.instantscore.presentation.screens.home_screen.state.FixturesState
import com.uxstate.instantscore.utils.Resource
import com.uxstate.instantscore.utils.UIEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {

    private val _fixturesState = MutableStateFlow(FixturesState())
    val fixturesState = _fixturesState.asStateFlow()

    private var job: Job? = null

    private val _uiEvent = Channel<UIEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {

        getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
    }

    private fun getFixtures(isRefresh: Boolean, date: LocalDate) {
        // cancel the running job before with start a new one

        job?.cancel()

        job = container.getFixturesByDateUseCase(isRefresh, date)
            .onEach {

                result ->

                when (result) {

                    is Resource.Success -> {

                        result.data?.let {
                            Timber.i("CachedData is $it")
                            _fixturesState.value = _fixturesState.value.copy(fixtures = it)
                        }
                    }
                    is Resource.Error -> {

                        // stop loading, set whatever data is available
                        _fixturesState.value = _fixturesState.value.copy(
                            isLoading = false,
                            fixtures = result.data ?: emptyMap()
                        )

                        sendUIEvent(
                            UIEvent.ShowSnackBarUiEvent(
                                message = result.errorMessage ?: "Unknown Error",
                                action = "OK"
                            )
                        )
                    }
                    is Resource.Loading -> {

                        _fixturesState.value =
                            _fixturesState.value.copy(isLoading = result.isLoading)
                    }
                }
            }
            .launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {

        when (event) {

            is OnRefresh -> {
                _fixturesState.value = _fixturesState.value.copy(isRefresh = event.isRefresh)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }

            is OnDateTabClick -> {
                _fixturesState.value = _fixturesState.value.copy(date = event.date)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }
            is OnCalendarDateSelection -> {

                _fixturesState.value = _fixturesState.value.copy(date = event.date)
                _fixturesState.value = _fixturesState.value.copy(isCalendarClicked = true)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }

            is OnHomeIconClick -> {

                _fixturesState.value = _fixturesState.value.copy(isCalendarClicked = false)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }
            is OnTogglePrevDate -> {
                _fixturesState.value = _fixturesState.value.copy(date = event.date)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }
            is OnToggleNextDate -> {

                _fixturesState.value = _fixturesState.value.copy(date = event.date)
                getFixtures(_fixturesState.value.isRefresh, _fixturesState.value.date)
            }
        }
    }

    fun sendUIEvent(event: UIEvent) {
        viewModelScope.launch {

            _uiEvent.send(event)
        }
    }
}