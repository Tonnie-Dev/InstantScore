package com.uxstate.instantscore.presentation.screens.details_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun DetailsScoreCard(fixture: Fixture) {
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Home Team
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = homeTeamPainter,
                contentDescription = fixture.teams.first.name,
                Modifier.size(spacing.spaceExtraLarge).padding(spacing.spaceSmall)
            )

            Text(text = fixture.teams.first.name, style = MaterialTheme.typography.titleMedium)
        }

        // Scores Row
        Row {
            Text(text = homeGoals, style = MaterialTheme.typography.displaySmall)
            Text(text = "-", style = MaterialTheme.typography.displaySmall)
            Text(text = awayGoals, style = MaterialTheme.typography.displaySmall)
        }

        // Away Team
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = homeTeamPainter,
                contentDescription = fixture.teams.first.name,
                Modifier.size(spacing.spaceExtraLarge)
            )

            Text(text = fixture.teams.first.name, style = MaterialTheme.typography.titleMedium)
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
