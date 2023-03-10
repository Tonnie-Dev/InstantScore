package com.uxstate.instantscore.presentation.screens.details_screen.components.lineup

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.uxstate.instantscore.domain.models.fixture_details.LineUp
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.fromHex

@Composable
fun StartingElevenCard(lineUps: List<LineUp>, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current

    val homeLineUp = lineUps[0]
    val awayLineUp = lineUps[1]

    val homeColor = Color.fromHex(homeLineUp.teamColor)
    val awayColor = Color.fromHex(awayLineUp.teamColor)

    Card(modifier = modifier.padding(spacing.spaceSmall)) {

        Row {

            // Home Column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                homeLineUp.startingXI.forEach { player ->
                    PlayerShirtCard(
                        player = player,
                        teamColor = homeColor
                    )
                }
            }

            // Away column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                awayLineUp.startingXI.forEach { player ->
                    PlayerShirtCard(
                        player = player,
                        teamColor = awayColor
                    )
                }
            }
        }
    }
}

@Composable
fun SubstitutesCard(lineUps: List<LineUp>, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current

    val homeLineUp = lineUps[0]
    val awayLineUp = lineUps[1]

    val homeColor = Color.fromHex(homeLineUp.teamColor)
    val awayColor = Color.fromHex(awayLineUp.teamColor)
    Card(modifier = modifier.padding(spacing.spaceSmall)) {

        Row {

            // Home Column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                homeLineUp.substitutes.forEach { player ->
                    PlayerShirtCard(
                        player = player,
                        teamColor = homeColor
                    )
                }
            }

            // Away column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                awayLineUp.substitutes.forEach { player ->
                    PlayerShirtCard(
                        player = player,
                        teamColor = awayColor
                    )
                }
            }
        }
    }
}

@Composable
fun CoachesCard(lineUps: List<LineUp>, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current

    val homeLineUp = lineUps[0]
    val awayLineUp = lineUps[1]

    val homeColor = Color.fromHex(homeLineUp.teamColor)
    val awayColor = Color.fromHex(awayLineUp.teamColor)

    Card(modifier = modifier.padding(spacing.spaceSmall)) {

        Row {

            // Home Column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                CoachPortraitCard(coach = homeLineUp.coach, teamColor = homeColor)
            }

            // Away column
            Column(
                verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.weight(1f)
            ) {
                CoachPortraitCard(coach = awayLineUp.coach, teamColor = awayColor)
            }
        }
    }
}
