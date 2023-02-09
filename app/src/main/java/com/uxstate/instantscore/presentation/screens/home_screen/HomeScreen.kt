package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.instantscore.presentation.screens.destinations.LiveFixturesScreenDestination
import com.uxstate.instantscore.presentation.screens.destinations.StandingsScreenDestination
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateTabsStrip
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card.LeagueFixturesCard
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.presentation.screens.standings_screen.LeagueNavArgumentsHolder
import com.uxstate.instantscore.utils.UIEvent
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Destination
@RootNavGraph(start = true)

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state by viewModel.fixturesState.collectAsState()

    val mappedFixtures = state.fixtures.toList()

    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isLoading,
        onRefresh = { viewModel.onEvent(HomeEvent.OnSwipeRefresh) }
    )

    // listen to UIEvent sent from the ViewModel, true to run once
    LaunchedEffect(key1 = true, block = {

        viewModel.uiEvent.collect {

            event ->
            when (event) {

                is UIEvent.ShowSnackBarUiEvent -> {

                    //  show snackbar as a suspend function
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(
                            message = event.message,
                            actionLabel = event.action,
                            duration = SnackbarDuration.Short
                        )
                    }
                }
                else -> Unit
            }
        }
    })

    Scaffold(snackbarHost = {
        SnackbarHost(
            hostState = snackbarHostState

        )
    }) { paddingValues ->
        Column() {

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
                        event = HomeEvent.OnHomeIconClick(date = LocalDate.now())
                    )
                },

                onTogglePrevDate = {

                    viewModel.onEvent(HomeEvent.OnTogglePrevDate(it))
                },

                onToggleNextDate = {
                    viewModel.onEvent(HomeEvent.OnToggleNextDate(it))
                },

                onClickLiveButton = {

                    navigator.navigate(LiveFixturesScreenDestination())
                },
                modifier = Modifier
                    .padding(paddingValues = paddingValues)

            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(-1f)
                    .pullRefresh(state = pullRefreshState)
            ) {

                if (state.isLoading)
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                else {
                    // content to be refreshed
                    LazyColumn(modifier = Modifier.fillMaxSize()) {

                        items(mappedFixtures) {

                            val league = it.first
                            LeagueFixturesCard(
                                league = it.first,
                                fixtures = it.second,
                                onClickFixtureCard = { fixtureId ->
                                    navigator.navigate(DetailsScreenDestination(fixtureId))
                                },

                                onClickLeagueHeader = {

                                    navigator.navigate(
                                        StandingsScreenDestination(
                                            navArgs = LeagueNavArgumentsHolder(
                                                id = league.id,
                                                name = league.name,
                                                country = league.country,
                                                leagueLogo = league.leagueLogo,
                                                countryFlag = league.countryFlag,
                                                season = league.season
                                            )
                                        )
                                    )
                                }
                            )
                        }
                    }

                    PullRefreshIndicator(
                        // controls the infinite spinning
                        refreshing = state.isRefresh,
                        state = pullRefreshState,
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }
            }
        }
    }
}
