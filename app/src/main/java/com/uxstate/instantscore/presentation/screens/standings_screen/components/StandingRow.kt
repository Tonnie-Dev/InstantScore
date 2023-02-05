package com.uxstate.instantscore.presentation.screens.standings_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.models.standings.Team
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingRow(standing: Standing, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Card(modifier = modifier.padding(spacing.spaceExtraSmall), shape = RectangleShape) {

        Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall),
                horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                    text = standing.rank.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light
            )
            Text(
                    text = standing.team.name,
                    modifier = Modifier.weight(.4f),
                    style = MaterialTheme.typography.bodyMedium,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = standing.matchPlayed.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light
            )
            Text(
                    text = "${standing.goalsFor}:${standing.goalsAgainst}",
                    modifier = Modifier.weight(.2f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Light
            )
            Text(
                    text = standing.goalsDiff.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light,

                    )
            Text(
                    text = standing.points.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Light
            )
        }
    }
}

@Preview
@Composable
fun StandingRowPreview() {

    val standing = Standing(
            description = "Promotion",
            goalsAgainst = 23,
            goalsFor = 47,
            goalsDiff = 24,
            matchPlayed = 21,
            group = "Group E",
            points = 64,
            rank = 3,
            team = Team(
                    id = 96,
                    name = "Tonnie FC",
                    logo = ""
            ),

            )

    InstantScoreTheme {
        StandingRow(standing = standing)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StandingRowPreviewDark() {

    val standing = Standing(
            description = "Promotion",
            goalsAgainst = 23,
            goalsFor = 47,
            goalsDiff = 24,
            matchPlayed = 21,
            group = "Group E",
            points = 64,
            rank = 3,
            team = Team(
                    id = 96,
                    name = "Tonnie FC",
                    logo = ""
            ),

            )

    InstantScoreTheme {
        StandingRow(standing = standing)
    }
}
