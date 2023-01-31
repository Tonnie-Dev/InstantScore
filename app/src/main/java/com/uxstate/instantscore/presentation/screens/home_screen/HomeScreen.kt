package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateTabsStrip
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixtures_column.FixturesColumn
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.UIEvent
import java.time.LocalDate
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
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
    val coroutineScope = rememberCoroutineScope()

    val swipeRefreshState = rememberPullRefreshState(
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

                modifier = Modifier
                    .padding(paddingValues = paddingValues)

            )
            FixturesColumn(
                mappedFixtures = mappedFixtures,
                navigator = navigator,
                swipeRefreshState = swipeRefreshState,
                isLoading = state.isLoading,
                isRefreshing = state.isRefresh
            )
            // the box is not bein recomposed
      /*      Box(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(-1f)
                    .pullRefresh(state = swipeRefreshState)
            ) {

                if (state.isLoading)
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                else {
                    // content to be refreshed
                    LazyColumn(modifier = Modifier.fillMaxSize()) {

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

                    PullRefreshIndicator(
                        // controls the infinite spinning
                        refreshing = state.isRefresh,
                        state = swipeRefreshState,
                        modifier = Modifier.align(Alignment.TopCenter)
                    )
                }
            }*/
        }
    }
}
