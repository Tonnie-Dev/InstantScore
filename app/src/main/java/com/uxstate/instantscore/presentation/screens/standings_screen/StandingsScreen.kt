package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.instantscore.presentation.screens.details_screen.DetailsScreenNavArgs


@Destination(navArgsDelegate = LeagueNavArgumentsHolder::class)
@Composable
fun StandingsScreen(viewModel: StandingsViewModel = hiltViewModel()) {

}

data class LeagueNavArgumentsHolder(
    val id: Int,
    val name: String,
    val country: String,
    val leagueLogo: String,
    val countryFlag: String,
    val season: Int
)