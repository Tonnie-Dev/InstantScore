package com.uxstate.instantscore.presentation.screens.home_screen.components.standings_table

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingRow(standing: Standing) {
}

@Composable
fun StandingHeader(
    rank: String,
    team: String,
    matchPlayed: String,
    goals: String,
    goalsDiff: String,
    points: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Card(modifier = modifier) {

        Row(modifier = Modifier.fillMaxSize()) {
            Text(
                text = rank,
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = team,
                modifier = Modifier.weight(.4f),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = matchPlayed,
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = goals,
                modifier = Modifier.weight(.2f),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = goalsDiff,
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = points,
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun StandingHeaderPreview() {

    InstantScoreTheme() {
        StandingHeader(
            rank = "3",
            team = "Manchester City",
            matchPlayed = "19",
            goals = "45:13",
            goalsDiff = "32",
            points = "50"
        )
    }
}