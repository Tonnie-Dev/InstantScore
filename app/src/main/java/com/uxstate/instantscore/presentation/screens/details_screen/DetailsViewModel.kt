package com.uxstate.instantscore.presentation.screens.details_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import com.uxstate.instantscore.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val useCaseContainer: UseCaseContainer) : ViewModel() {


    init {

        getFixtureDetails( fixtureId=868134 )

    }


    private fun getFixtureDetails(fixtureId:Int ){

        useCaseContainer.getFixtureDetailsUseCase(fixtureId).onEach { result ->

            when(result){

                is Resource.Success -> {}
                is Resource.Loading -> {}
                is Resource.Error -> {}
            }

            
        }.launchIn(viewModelScope)
    }
}