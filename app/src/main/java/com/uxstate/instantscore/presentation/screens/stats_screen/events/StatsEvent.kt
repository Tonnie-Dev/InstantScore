package com.uxstate.instantscore.presentation.screens.stats_screen.events

sealed class StatsEvent(){

    data class OnChipClick(val statType:String): StatsEvent()
}
