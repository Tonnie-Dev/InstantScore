package com.uxstate.instantscore.presentation.screens.standings_screen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.presentation.screens.standings_screen.components.StandingsHeader

@Destination(navArgsDelegate = LeagueNavArgumentsHolder::class)
@Composable
fun StandingsScreen(
    navArgs: LeagueNavArgumentsHolder,
    viewModel: StandingsViewModel = hiltViewModel()
) {

    StandingsHeader(
        league = League(
            id = navArgs.id,
            name = navArgs.name,
            country = navArgs.country,
            leagueLogo = navArgs.leagueLogo,
            countryFlag = navArgs.countryFlag,
            season = navArgs.season
        )
    )
}

data class LeagueNavArgumentsHolder(
    val id: Int,
    val name: String,
    val country: String,
    val leagueLogo: String,
    val countryFlag: String,
    val season: Int
)