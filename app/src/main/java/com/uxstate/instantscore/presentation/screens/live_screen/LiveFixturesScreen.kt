package com.uxstate.instantscore.presentation.screens.live_screen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixtures_column.FixturesColumn
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent
import com.uxstate.instantscore.presentation.screens.live_screen.components.LiveFixturesHeader
import com.uxstate.instantscore.presentation.screens.live_screen.components.LiveFixturesList
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.UIEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun LiveFixturesScreen(viewModel: LiveFixturesViewModel = hiltViewModel(),navigator:DestinationsNavigator) {
    
    val spacing = LocalSpacing.current
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember{ SnackbarHostState() }


    val state by viewModel.liveFixturesState.collectAsState()
    val pullRefreshState = rememberPullRefreshState(
            refreshing = state.isLoading,
            onRefresh = {  }
    )


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
    Scaffold(snackbarHost = { SnackbarHost(hostState = snackbarHostState)}) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            LiveFixturesHeader()
           LiveFixturesList(
                    mappedFixtures = state.fixturesMap.toList(),
                    navigator = navigator,
                    pullRefreshState = pullRefreshState,
                    isLoading =  state.isLoading,
                    isRefreshing = state.isLoading
            )
        }

    }
}