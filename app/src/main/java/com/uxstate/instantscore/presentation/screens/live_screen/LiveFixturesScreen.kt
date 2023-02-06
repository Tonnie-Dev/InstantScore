package com.uxstate.instantscore.presentation.screens.live_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LiveFixturesScreen(viewModel: LiveFixturesViewModel = hiltViewModel()) {

    val state = viewModel.liveFixturesState
}