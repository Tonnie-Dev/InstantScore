package com.uxstate.instantscore.presentation.screens.live_screen

import androidx.lifecycle.ViewModel
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LiveFixturesViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer
) : ViewModel() {


}