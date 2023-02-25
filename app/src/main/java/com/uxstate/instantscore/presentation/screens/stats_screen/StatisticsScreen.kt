package com.uxstate.instantscore.presentation.screens.stats_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.instantscore.presentation.screens.stats_screen.components.PlayerStatsList
import com.uxstate.instantscore.presentation.screens.stats_screen.components.StatsChipRow
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.UIEvent
import kotlinx.coroutines.launch

@Destination(navArgsDelegate = statsNavArgs::class)
@Composable
fun StatisticsScreen(viewModel: StatisticsViewModel = hiltViewModel()) {

    val state by viewModel.state.collectAsState()

    val stats = state.stats

    val spacing = LocalSpacing.current
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(key1 = true, block = {

        viewModel.uiEvent.collect { event ->
            when (event) {

                is UIEvent.ShowSnackBarUiEvent -> {

                    coroutineScope.launch {

                        snackbarHostState.showSnackbar(
                            event.message,
                            event.action,
                            SnackbarDuration.Short
                        )
                    }
                }
            }
        }
    })

    Scaffold(snackbarHost = {
        SnackbarHost(hostState = snackbarHostState)
    }) { paddingValues ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            StatsChipRow(onClickChip = { /*TODO*/ })

            PlayerStatsList(stats = stats)
        }
    }
}

data class statsNavArgs(val statType: String = "topscorers", val leagueId: Int, val season: Int)