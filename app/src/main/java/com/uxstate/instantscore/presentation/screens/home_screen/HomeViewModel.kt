package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val container: UseCaseContainer
) : ViewModel() {



    fun getFixtures(){

        container.getFixturesUseCase(true).onEach {

            result ->

            when(result){

                is Resource.Success -> {}
                is Resource.Error -> {}
                is Resource.Loading -> {}
            }

        }.launchIn(viewModelScope)
    }
}