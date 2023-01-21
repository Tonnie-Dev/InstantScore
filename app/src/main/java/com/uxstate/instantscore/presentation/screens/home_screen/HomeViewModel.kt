package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent.*
import com.uxstate.instantscore.presentation.screens.home_screen.state.FixturesState
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {

    private val _fixturesState = MutableStateFlow(FixturesState())
    val fixturesState = _fixturesState.asStateFlow()

    private var job: Job? = null

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

                        result.errorMessage?.let {
                            _fixturesState.value = _fixturesState.value.copy(errorMessage = it)
                        }
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
}