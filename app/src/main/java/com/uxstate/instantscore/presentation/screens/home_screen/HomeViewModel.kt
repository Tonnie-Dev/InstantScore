package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent.*
import com.uxstate.instantscore.presentation.screens.home_screen.state.FixturesState
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.time.LocalDate

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {

    private val _fixturesState = MutableStateFlow(FixturesState())
    val fixturesState = _fixturesState.asStateFlow()



    var job:Job? = null

    init {

        getFixtures()
    }

    private fun getFixtures() {
        //cancel the running job before with start a new one

        job?.cancel()

     job =   container.getFixturesByDateUseCase(isRefresh = false, date = LocalDate.now())
            .onEach {

                result ->

                when (result) {

                    is Resource.Success -> {

                        result.data?.let {

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

            is OnRefresh -> {}
            is OnFixtureDateSelection -> {

                _fixturesState.value = event.date

            }
        }
    }
}