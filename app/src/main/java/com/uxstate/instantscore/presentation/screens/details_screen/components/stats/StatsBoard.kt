package com.uxstate.instantscore.presentation.screens.details_screen.components.stats

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.presentation.screens.common_components.LottieDefinition
import com.uxstate.instantscore.utils.LocalSpacing
import timber.log.Timber

@Composable
fun StatsBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val stats = generateStatsPairs(fixtureDetails)
    if (stats.isNotEmpty()) {
        Card(modifier = modifier) {
            Column(modifier = Modifier.verticalScroll(rememberScrollState())) {

                stats.forEach { (stat, statPair) ->

                    StatsPair(
                        statType = stat,
                        homeStatValue = statPair.first,
                        awayStatValue = statPair.second
                    )
                }
            }
        }
    } else {

        Card(modifier = Modifier.padding(spacing.spaceSmall)) {

            LottieDefinition(
                lottieRes = R.raw.empty_info,
                modifier = Modifier.size(spacing.spaceExtraLarge)
            )
        }
    }
}

fun generateStatsPairs(fixtureDetails: FixtureDetails): Map<String, Pair<Int, Int>> {

    val stats = fixtureDetails.stats

    if (stats.isNotEmpty()) {
        // possession
        val homePossession = stats.first { it.type == "Ball Possession" }.value
        val awayPossession = stats.findLast { it.type == "Ball Possession" }?.value!!

        // shots on goal
        val homeShotsOnGoal = stats.first { it.type == "Shots on Goal" }.value
        val awayShotsOnGoal = stats.findLast { it.type == "Shots on Goal" }?.value!!

        Timber.i("Home shots: $homeShotsOnGoal away Shots: $awayShotsOnGoal")

        // shots off goal
        val homeShotsOffGoal = stats.first { it.type == "Shots off Goal" }.value
        val awayShotsOffGoal = stats.findLast { it.type == "Shots off Goal" }?.value!!
        Timber.i("Home off shots: $homeShotsOffGoal away off Shots: $awayShotsOffGoal")
        // total shots
        val homeTotalShots = stats.first { it.type == "Total Shots" }.value
        val awayTotalShots = stats.findLast { it.type == "Total Shots" }?.value!!
        Timber.i("Home total shots: $homeTotalShots away total Shots: $awayTotalShots")
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

        val mappedStats = mapOf(
            "Ball Possession" to Pair(homePossession, awayPossession),
            "Shots on Target" to Pair(homeShotsOnGoal, awayShotsOnGoal),
            "Shots Off Target" to Pair(homeShotsOffGoal, awayShotsOffGoal),
            "Total Shots" to Pair(homeTotalShots, awayTotalShots),
            "Corner Kicks" to Pair(homeCorners, awayCorners),
            "Offsides" to Pair(homeOffsides, awayOffsides),
            "Fouls" to Pair(homeFouls, awayFouls),
            "Yellow Cards" to Pair(homeYellowCard, awayYellowCard),
            "Red Cards" to Pair(homeRedCards, awayRedCards)
        )

        Timber.i("The Mapped Stats are $mappedStats")
        return mappedStats
    } else {
        return emptyMap()
    }
}