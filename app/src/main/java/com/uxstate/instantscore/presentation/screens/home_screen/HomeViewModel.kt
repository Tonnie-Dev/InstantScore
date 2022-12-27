package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {

    private val _state = MutableStateFlow("")
    val state = _state.asStateFlow()

    private val _fixturesState = MutableStateFlow(FixturesState())
    val fixturesState = _fixturesState.asStateFlow()

    init {
        Timber.i("HomeViewModel Init Block")
        getIncome()
        // getFixtures()
    }

    private fun getFixtures() {

        container.getFixturesUseCase(true)
            .onEach {

                result ->

                when (result) {

                    is Resource.Success -> {

                        result.data?.let {

                            _fixturesState.value = _fixturesState.value.copy(fixturesData = it)
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

    private fun getIncome() {

        container.getIncomeUseCase().onEach {

            result ->

            when (result) {

                is Resource.Success -> {
                    _state.value = "Success, payment is ${result.data}"
                    Timber.i("Success, payment is ${result.data}")
                }
                is Resource.Error -> {
                    _state.value = "Success, payment is ${result.data}"
                    Timber.i("Funny Error Occurred")
                }
                is Resource.Loading -> {}
            }
        }.launchIn(viewModelScope)
    }
}