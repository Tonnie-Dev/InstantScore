package com.uxstate.instantscore.presentation.screens.details_screen.components.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails

@Composable
fun StatsBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {

    val stats = generateStatsPairs(fixtureDetails)

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {

        stats.forEach { (stat, statPair) ->

            StatsPair(
                statType = stat,
                homeStatValue = statPair.first,
                awayStatValue = statPair.second
            )
        }
    }
}

fun generateStatsPairs(fixtureDetails: FixtureDetails): Map<String, Pair<Int, Int>> {

    val stats = fixtureDetails.realStats

    // possession
    val homePossession = stats.first { it.type == "Ball Possession" }.value
    val awayPossession = stats.findLast { it.type == "Ball Possession" }?.value!!

    // shots on goal
    val homeShotsOnGoal = stats.first { it.type == "Shots on Goal" }.value
    val awayShotsOnGoal = stats.findLast { it.type == "Shots on Goal" }?.value!!

    // shots off goal
    val homeShotsOffGoal = stats.first { it.type == "Shots off Goal" }.value
    val awayShotsOffGoal = stats.findLast { it.type == "Shots off Goal" }?.value!!

    // total shots
    val homeTotalShots = stats.first { it.type == "Total Shots" }.value
    val awayTotalShots = stats.findLast { it.type == "Total Shots" }?.value!!

    // corners
    val homeCorners = stats.first { it.type == "Corner Kicks" }.value
    val awayCorners = stats.findLast { it.type == "Corner Kicks" }?.value!!

    // offsides
    val homeOffsides = stats.first { it.type == "Offsides" }.value
    val awayOffsides = stats.findLast { it.type == "Offsides" }?.value!!

    // fouls
    val homeFouls = stats.first { it.type == "Fouls" }.value
    val awayFouls = stats.findLast { it.type == "Fouls" }?.value!!

    // yellowCards
    val homeYellowCard = stats.first { it.type == "Yellow Cards" }.value
    val awayYellowCard = stats.findLast { it.type == "Yellow Cards" }?.value!!

    // redCards
    val homeRedCards = stats.first { it.type == "Red Cards" }.value
    val awayRedCards = stats.findLast { it.type == "Red Cards" }?.value!!

    return mapOf(
        "Ball Possession" to Pair(homeShotsOnGoal, awayShotsOnGoal),
        "Shots on Target" to Pair(homeShotsOnGoal, awayShotsOnGoal),
        "Shots Off Target" to Pair(homeShotsOffGoal, awayShotsOffGoal),
        "Total Shots" to Pair(homeTotalShots, awayTotalShots),
        "Corner Kicks" to Pair(homeCorners, awayCorners),
        "Offsides" to Pair(homeOffsides, awayOffsides),
        "Fouls" to Pair(homeFouls, awayFouls),
        "Yellow Cards" to Pair(homeYellowCard, awayYellowCard),
        "Red Cards" to Pair(homeRedCards, awayRedCards)
    )
}