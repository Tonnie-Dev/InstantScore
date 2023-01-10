package com.uxstate.instantscore.presentation.screens.details_screen.components.tabs

import androidx.compose.runtime.Composable

sealed class TabItemSealedClass(val tabTitle: String, val composeFunction: @Composable () -> Unit) {

    object EventsTab : TabItemSealedClass(tabTitle = "Event", composeFunction = {})
    object LineUpsTab : TabItemSealedClass(tabTitle = "Lineups", composeFunction = {})
    object StatsTab : TabItemSealedClass(tabTitle = "Stats", composeFunction = {})
}
