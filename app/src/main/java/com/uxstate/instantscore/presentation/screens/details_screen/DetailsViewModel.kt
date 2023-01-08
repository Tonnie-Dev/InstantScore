package com.uxstate.instantscore.presentation.screens.details_screen

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

@HiltViewModel
class DetailsViewModel @Inject constructor(private val useCaseContainer: UseCaseContainer) :
    ViewModel() {
    private val _fakeState = MutableStateFlow("")
    val fakeState = _fakeState.asStateFlow()

    init {

        getFixtureDetails(fixtureId = 868134)
    }

    private fun getFixtureDetails(fixtureId: Int) {

        useCaseContainer.getFixtureDetailsUseCase(fixtureId)
            .onEach { result ->

                when (result) {

                    is Resource.Success -> {

                        val id = result.data?.fixtureId

                        _fakeState.value = id.toString()
                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Error -> {
                        result.errorMessage?.let {
                            _fakeState.value = it
                        }
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}