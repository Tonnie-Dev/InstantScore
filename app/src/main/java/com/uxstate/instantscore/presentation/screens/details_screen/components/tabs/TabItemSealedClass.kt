package com.uxstate.instantscore.presentation.screens.details_screen.components.tabs

import androidx.compose.runtime.Composable
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.presentation.screens.details_screen.components.events.EventsBoard
import com.uxstate.instantscore.presentation.screens.details_screen.components.lineup.LineUpBoard
import com.uxstate.instantscore.presentation.screens.details_screen.components.stats.StatsBoard

sealed class TabItemSealedClass(val tabTitle: String, val composeFunction: @Composable () -> Unit) {

    data class EventsTab(val fixtureDetails: FixtureDetails) : TabItemSealedClass(
        tabTitle = "Event",
        composeFunction = {

            EventsBoard(fixtureDetails = fixtureDetails)
        }
    )

    data class LineUpsTab(val fixtureDetails: FixtureDetails) : TabItemSealedClass(
        tabTitle = "Lineups",
        composeFunction = {

            LineUpBoard(fixtureDetails = fixtureDetails)
        }
    )

    data class StatsTab(val fixtureDetails: FixtureDetails) : TabItemSealedClass(
        tabTitle = "Stats",
        composeFunction = {

            StatsBoard(fixtureDetails = fixtureDetails)
        }
    )
}
