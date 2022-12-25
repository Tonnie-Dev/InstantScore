package com.uxstate.instantscore.presentation.screens.home_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.uxstate.instantscore.presentation.screens.home_screen.components.MatchCard

@Destination
@RootNavGraph(start = true)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val state by viewModel.fixturesState.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {

        LazyColumn {

            items(state.fixturesData) { fixture ->

                MatchCard(fixture = fixture)
            }
        }
    }
}