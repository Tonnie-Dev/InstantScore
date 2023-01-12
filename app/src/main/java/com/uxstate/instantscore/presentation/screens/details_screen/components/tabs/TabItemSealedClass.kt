package com.uxstate.instantscore.presentation.screens.details_screen.components.tabs

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.presentation.screens.details_screen.components.events.EventsBoard
import com.uxstate.instantscore.presentation.screens.details_screen.components.lineup.LineUpBoard

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

    object StatsTab : TabItemSealedClass(tabTitle = "Stats", composeFunction = {

        Text(text = "Test 5")
    })
}
