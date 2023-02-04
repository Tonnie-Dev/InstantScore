package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.presentation.screens.standings_screen.components.StandingRowHeader
import com.uxstate.instantscore.presentation.screens.standings_screen.components.StandingsHeader
import com.uxstate.instantscore.presentation.screens.standings_screen.components.StandingsTable
import com.uxstate.instantscore.utils.UIEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Destination(navArgsDelegate = LeagueNavArgumentsHolder::class)
@Composable
fun StandingsScreen(
    navArgs: LeagueNavArgumentsHolder,
    viewModel: StandingsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state by viewModel.standingsState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    // Listen to uiEvents sent from the ViewModel
    LaunchedEffect(key1 = true, block = {

        viewModel.uiEvent.collect { uiEvent ->
            when (uiEvent) {

                is UIEvent.ShowSnackBarUiEvent -> {

                    coroutineScope.launch {

                        snackbarHostState.showSnackbar(
                            message = uiEvent.message,
                            actionLabel = uiEvent.action,
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            }
        }
    })

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState) }) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues = paddingValues)) {
            StandingsHeader(
                league = League(
                    id = navArgs.id,
                    name = navArgs.name,
                    country = navArgs.country,
                    leagueLogo = navArgs.leagueLogo,
                    countryFlag = navArgs.countryFlag,
                    season = navArgs.season
                ),
                onNavigateBack = {
                    navigator.navigateUp()
                }
            )

            StandingRowHeader()

            Box(contentAlignment = Alignment.Center) {
                if (state.isLoading) {

                    CircularProgressIndicator()
                } else {

                    StandingsTable(standings = state.standingsList)
                }
            }
        }
    }
}

data class LeagueNavArgumentsHolder(
    val id: Int,
    val name: String,
    val country: String,
    val leagueLogo: String,
    val countryFlag: String,
    val season: Int
)