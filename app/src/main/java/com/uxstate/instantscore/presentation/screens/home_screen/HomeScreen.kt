package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateStrip
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card.LeagueFixturesCard
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.utils.LocalSpacing

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel(), navigator: DestinationsNavigator) {
    val state by viewModel.fixturesState.collectAsState()

    val spacing = LocalSpacing.current

    val mappedFixtures = state.fixtures.toList()

    Scaffold { paddingValues ->
        Column() {

            Column() {
                Spacer(modifier = Modifier.height(spacing.spaceSmall))
                DateStrip(
                    modifier = Modifier
                        .padding(paddingValues = paddingValues)
                        .padding(spacing.spaceSmall),
                    onDateChange = {
                        viewModel.onEvent(event = HomeEvent.OnFixtureDateSelection(date = it))
                    }
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

                if (state.isLoading)

                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                else

                    LazyColumn(content = {

                        items(mappedFixtures) {

                            LeagueFixturesCard(
                                league = it.first,
                                fixtures = it.second,
                                onClickFixtureCard = {
                                    navigator.navigate(DetailsScreenDestination(it))
                                }
                            )
                        }
                    })
            }
        }
    }
}
