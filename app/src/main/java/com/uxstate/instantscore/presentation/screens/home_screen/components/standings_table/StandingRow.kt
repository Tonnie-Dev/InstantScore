package com.uxstate.instantscore.presentation.screens.home_screen.components.standings_table

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
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
    Card(modifier = modifier, shape = RectangleShape) {

        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall),
                horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                    text = rank,
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = team,
                    modifier = Modifier.weight(.4f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = matchPlayed,
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = goals,
                    modifier = Modifier.weight(.2f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = goalsDiff,
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = points,
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
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

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StandingHeaderPreviewDark() {

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