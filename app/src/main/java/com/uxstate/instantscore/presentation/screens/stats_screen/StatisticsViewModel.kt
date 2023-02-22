package com.uxstate.instantscore.presentation.screens.stats_screen

import androidx.lifecycle.ViewModel
import com.uxstate.instantscore.domain.usecases.UseCaseContainer
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val useCaseContainer: UseCaseContainer
) : ViewModel() {

    private val _state = MutableStateFlow(StatState())
    val state = _state.asStateFlow()


    private fun getStats(leagueId:Int, season:Int, statType:String){

        useCaseContainer.getStatsUseCase(leagueId = leagueId, season = season).onEach {

            result ->

            //when(result){}
        }
    }
}