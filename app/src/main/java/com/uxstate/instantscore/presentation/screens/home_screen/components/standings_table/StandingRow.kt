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
import com.uxstate.instantscore.domain.models.standings.League
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.models.standings.Team
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingRow(standing: Standing, modifier:Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Card(modifier = modifier, shape = RectangleShape) {

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
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = standing.team.name,
                    modifier = Modifier.weight(.4f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = standing.matchPlayed.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = "${standing.goalsFor}:${standing.goalsAgainst}",
                    modifier = Modifier.weight(.2f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = standing.goalsDiff.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
            Text(
                    text = standing.points.toString(),
                    modifier = Modifier.weight(.1f),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Black
            )
        }
    }


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

            league = League(
                    id = 0,
                    name = "",
                    country = "",
                    leagueLogo = "",
                    countryFlag = "",
                    season = 0
            )
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

            league = League(
                    id = 0,
                    name = "",
                    country = "",
                    leagueLogo = "",
                    countryFlag = "",
                    season = 0
            )
    )

    InstantScoreTheme {
        StandingRow(standing = standing)
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