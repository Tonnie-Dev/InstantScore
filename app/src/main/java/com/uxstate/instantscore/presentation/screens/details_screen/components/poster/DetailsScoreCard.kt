package com.uxstate.instantscore.presentation.screens.details_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun DetailsScoreCard(details: FixtureDetails, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val homeGoals = if (details.homeGoals == -1) "" else "${details.homeGoals}"
    val awayGoals = if (details.awayGoals == -1) "" else "${details.awayGoals}"

    val homeTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(details.teams.first.logo)
            .crossfade(enable = true)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .build()

    )

    val awayTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(details.teams.second.logo)
            .crossfade(enable = true)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .build()
    )

    Column(
        modifier = modifier.padding(spacing.spaceSmall),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = details.leagueName,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            // modifier = Modifier.fillMaxWidth(.7f)
        ) {

            // Home Team
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = homeTeamPainter,
                    contentDescription = details.teams.first.name,
                    Modifier
                        .size(spacing.spaceExtraLarge)

                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                Text(
                    text = details.teams.first.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.White
                )
            }

            // Scores Row
            Row(verticalAlignment = Alignment.Top) {
                Text(
                    text = homeGoals,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Text(
                    text = " - ",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Text(
                    text = awayGoals,
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

            // Away Team
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = awayTeamPainter,
                    contentDescription = details.teams.first.name,
                    Modifier.size(spacing.spaceExtraLarge)
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                Text(
                    text = details.teams.second.name,
                    style = MaterialTheme.typography.titleMedium, color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailsScoreCardPreview() {
    InstantScoreTheme() {
        DetailsScoreCard(
            details = FixtureDetails(
                fixtureId = -1,
                timeStamp = 0L,
                referee = "",
                venue = "",
                status = "",
                timeElapsed = -1,
                homeGoals = 5,
                awayGoals = 0,
                leagueName = "",
                teams = Pair(
                    first = Team(
                        name = "Arsenal",
                        logo = "",
                        isWinner = false
                    ),
                    second = Team(
                        name = "Brighton",
                        logo = "",
                        isWinner = false
                    )
                ),
                events = listOf(),
                stats = listOf(),
                lineUps = listOf(),
                score = Score(
                    extraTimeScore = ExtraTime(
                        extraTimeAwayScore = 0,
                        extraTimeHomeScore = 0
                    ),
                    fullTimeScore = FullTime(fullTimeAwayScore = 0, fullTimeHomeScore = 0),
                    penaltyShootOutScore = PenaltyShootOut(
                        penaltiesScoredAway = 0,
                        penaltiesScoredHome = 0
                    )
                ),
                stats = listOf()
            )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScoreCardPreviewDark() {
    InstantScoreTheme() {
        DetailsScoreCard(
            details = FixtureDetails(
                fixtureId = -1,
                timeStamp = 0L,
                referee = "",
                venue = "",
                status = "",
                timeElapsed = -1,
                homeGoals = 8,
                awayGoals = 2,
                leagueName = "",
                teams = Pair(
                    first = Team(
                        name = "Liverpool",
                        logo = "",
                        isWinner = false
                    ),
                    second = Team(
                        name = "",
                        logo = "",
                        isWinner = false
                    )
                ),
                events = listOf(),
                stats = listOf(),
                lineUps = listOf(),
                score = Score(
                    extraTimeScore = ExtraTime(
                        extraTimeAwayScore = 0,
                        extraTimeHomeScore = 0
                    ),
                    fullTimeScore = FullTime(fullTimeAwayScore = 0, fullTimeHomeScore = 0),
                    penaltyShootOutScore = PenaltyShootOut(
                        penaltiesScoredAway = 0,
                        penaltiesScoredHome = 0
                    )
                ),
                stats = listOf()
            )
        )
    }
}
