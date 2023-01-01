package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateStrip
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card.LeagueMatchesCard
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.fixturesState.collectAsState()
    val map = mapOf<String, String>()

    val mappedFixtures = state.fixtures.groupBy { it.league }

    val keys = mappedFixtures.keys.map {
        it
    }
    val entries = mappedFixtures.entries.map {

        it
    }

    Scaffold { paddingValues ->
        Column() {
            Text(text = "Test 1")
            DateStrip(
                modifier = Modifier.padding(paddingValues = paddingValues),
                onDateChange = {
                    viewModel.onEvent(event = HomeEvent.OnFixtureDateSelection(date = it))
                }
            )
            mappedFixtures.forEach { (k, v) -> LeagueMatchesCard(k, v) }

            Text(text = "Test 2")
        }
    }
}


