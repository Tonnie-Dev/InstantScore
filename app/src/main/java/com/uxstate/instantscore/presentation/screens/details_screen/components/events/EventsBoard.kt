package com.uxstate.instantscore.presentation.screens.details_screen.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails

@Composable
fun EventsBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {

    val homeTeamEvents = fixtureDetails.events[0]
    val awayTeamEvents = fixtureDetails.events[1]
}