package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip.DateStrip
import com.uxstate.instantscore.presentation.screens.home_screen.events.HomeEvent

@OptIn(ExperimentalMaterial3Api::class)
@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.fixturesState.collectAsState()

    Scaffold { paddingValues ->

        DateStrip(
                modifier = Modifier.padding(paddingValues = paddingValues),
                onDateChange = {
                    viewModel.onEvent(event = HomeEvent.OnFixtureDateSelection(date = it))
                })
    }
}