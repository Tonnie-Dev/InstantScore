package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {

    private var _fixturesState = MutableStateFlow(FixturesState())
    val fixturesState = _fixturesState.asStateFlow()

    init {

        getFixtures()
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
}