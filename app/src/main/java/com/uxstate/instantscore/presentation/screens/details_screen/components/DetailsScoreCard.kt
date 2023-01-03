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
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun DetailsScoreCard(fixture: Fixture, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val homeGoals = if (fixture.goals.homeTeamScore == -1) "" else "${fixture.goals.homeTeamScore}"
    val awayGoals = if (fixture.goals.awayTeamScore == -1) "" else "${fixture.goals.awayTeamScore}"

    val homeTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(fixture.teams.first.logo)
            .crossfade(enable = true)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .build()

    )

    val awayTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(fixture.teams.second.logo)
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
            text = fixture.league.name,
            style = MaterialTheme.typography.titleLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(spacing.spaceLarge))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(.7f)
        ) {

            // Home Team
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = homeTeamPainter,
                    contentDescription = fixture.teams.first.name,
                    Modifier
                        .size(spacing.spaceExtraLarge)

                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                Text(
                    text = fixture.teams.first.name,
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
                    contentDescription = fixture.teams.first.name,
                    Modifier.size(spacing.spaceExtraLarge)
                )
                Spacer(modifier = Modifier.height(spacing.spaceExtraSmall))
                Text(
                    text = fixture.teams.first.name,
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
            fixture = Fixture(
                fixtureId = 0, date = LocalDate.now(),
                status = Status(
                    fixtureLong = "",
                    fixtureShort = "FT",
                    timeElapsed = 63
                ),
                league = League(
                    id = 0,
                    name = "China League",
                    country = "",
                    leagueLogo = "",
                    countryFlag = ""
                ),
                teams = Pair(
                    Team(name = "Auxere", logo = ""),
                    Team(name = "Monaco", logo = "")
                ),
                goals = Goal(
                    homeTeamScore = 5,
                    awayTeamScore = 3
                ),
                startTime = 1672774200
            )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DetailsScoreCardPreviewDark() {
    InstantScoreTheme() {
        DetailsScoreCard(
            fixture = Fixture(
                fixtureId = 0, date = LocalDate.now(),
                status = Status(
                    fixtureLong = "",
                    fixtureShort = "FT",
                    timeElapsed = 63
                ),
                league = League(
                    id = 0,
                    name = "China League",
                    country = "",
                    leagueLogo = "",
                    countryFlag = ""
                ),
                teams = Pair(
                    Team(name = "Auxere", logo = ""),
                    Team(name = "Monaco", logo = "")
                ),
                goals = Goal(
                    homeTeamScore = 5,
                    awayTeamScore = 3
                ),
                startTime = 1672774200
            )
        )
    }
}
