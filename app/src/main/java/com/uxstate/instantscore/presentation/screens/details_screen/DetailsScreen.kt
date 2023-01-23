package com.uxstate.instantscore.presentation.screens.details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.presentation.screens.details_screen.components.FixturePoster
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabItemSealedClass
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabsContent
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabsRow
import com.uxstate.instantscore.utils.UIEvent
import kotlinx.coroutines.launch
import timber.log.Timber

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun DetailsScreen(
    fixtureId: Int,
    viewModel: DetailsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.fakeState.collectAsState()
    val pageState = rememberPagerState()
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    val tabs = listOf(
        TabItemSealedClass.EventsTab(fixtureDetails = state.fixtureDetails),
        TabItemSealedClass.LineUpsTab(fixtureDetails = state.fixtureDetails),
        TabItemSealedClass.StatsTab(fixtureDetails = state.fixtureDetails)
    )

    // listen to UIEvent

    LaunchedEffect(key1 = true, block = {

        Timber.i("Inside DetailsScreen LaunchedBloc,")
        viewModel.uiEvent.collect {
            event ->
            when (event) {

                is UIEvent.ShowSnackBarUiEvent -> {

                    Timber.i("Show Snackbar now")
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(event.message)
                    }
                }
            }
        }
    })

    Scaffold(snackbarHost = { SnackbarHost(hostState = (snackbarHostState)) }) { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

            FixturePoster(details = state.fixtureDetails) { navigator.navigateUp() }
            TabsRow(tabs = tabs, pagerState = pageState)
            TabsContent(tabs = tabs, pagerState = pageState)
        }
    }
}