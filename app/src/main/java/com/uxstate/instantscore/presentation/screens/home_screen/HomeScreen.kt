package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateTabsStrip
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card.LeagueFixturesCard
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.UIEvent
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state by viewModel.fixturesState.collectAsState()

    val spacing = LocalSpacing.current

    val mappedFixtures = state.fixtures.toList()

    val snackbarHostState = remember { SnackbarHostState() }

    // listen to UIEvent sent from the ViewModel, true to run once
    LaunchedEffect(key1 = true, block = {

        viewModel.uiEvent.collect {

            event ->
            when (event) {

                is UIEvent.ShowSnackBarUiEvent -> {

                    // show snackbar

                    snackbarHostState.showSnackbar(
                        message = event.message,
                        actionLabel = event.action,
                        duration = SnackbarDuration.Short
                    )
                }
            }
        }
    })

    Scaffold { paddingValues ->
        Column() {

            Column() {

                Spacer(modifier = Modifier.height(spacing.spaceSmall))

                DateTabsStrip(
                    date = state.date,
                    isCalendarClicked = state.isCalendarClicked,
                    onDateTabClick = {
                        viewModel.onEvent(HomeEvent.OnDateTabClick(it))
                    },
                    onCalendarDateChange = {
                        viewModel.onEvent(event = HomeEvent.OnCalendarDateSelection(date = it))
                    },

                    onHomeDateTabClick = {
                        viewModel.onEvent(
                            event =
                            HomeEvent.OnHomeIconClick(date = LocalDate.now())
                        )
                    },

                    onTogglePrevDate = {

                        viewModel.onEvent(HomeEvent.OnTogglePrevDate(it))
                    },
                    onToggleNextDate = {
                        viewModel.onEvent(HomeEvent.OnToggleNextDate(it))
                    },

                    modifier = Modifier
                        .padding(paddingValues = paddingValues)
                        .padding(spacing.spaceSmall)
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

                if (state.isLoading)

                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                else

                    LazyColumn {

                        items(mappedFixtures) {

                            LeagueFixturesCard(
                                league = it.first,
                                fixtures = it.second,
                                onClickFixtureCard = { fixtureId ->
                                    navigator.navigate(DetailsScreenDestination(fixtureId))
                                }
                            )
                        }
                    }
            }
        }
    }
}
