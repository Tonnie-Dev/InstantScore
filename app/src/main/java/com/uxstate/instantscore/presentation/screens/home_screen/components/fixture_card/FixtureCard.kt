package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.toHourMinuteFormat
import java.time.LocalDate

@Composable
fun FixtureCard(
    fixture: Fixture,
    onClickFixtureCard: (fixtureId: Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val fixtureSideText = when (fixture.status.fixtureShort) {

        "NS" -> fixture.startTime.toHourMinuteFormat()
        "FT" -> stringResource(R.string.ft_abbreviation)
        "1H" -> "${fixture.status.timeElapsed}'"
        "2H" -> "${fixture.status.timeElapsed}'"
        "PST" -> stringResource(R.string.pst_abbreviation)
        else -> ""
    }

    val homeGoals = if (fixture.goals.homeTeamScore == -1) "" else "${fixture.goals.homeTeamScore}"
    val awayGoals = if (fixture.goals.awayTeamScore == -1) "" else "${fixture.goals.awayTeamScore}"
    val homeTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(fixture.teams.first.logo)
            .error(R.drawable.empty_flag)
            .placeholder(R.drawable.empty_flag)
            .crossfade(true)
            .build()
    )

    val awayTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(fixture.teams.second.logo)
            .error(R.drawable.empty_flag)
            .placeholder(R.drawable.empty_flag)
            .crossfade(true)
            .build()
    )

    Card(
        modifier = modifier
            .clickable {

                onClickFixtureCard(fixture.fixtureId)
            }
            .padding(
                vertical = spacing.spaceExtraSmall,
                horizontal = spacing.spaceSmall
            ),
        shape = RectangleShape
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .padding(spacing.spaceExtraSmall)
        ) {

            Text(
                text = fixtureSideText,
                modifier = Modifier.align(Alignment.CenterVertically).weight(.13f).fillMaxWidth(),
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.titleSmall
            )

            Column(modifier = Modifier.padding(spacing.spaceSmall).weight(.87f)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Image(
                            painter = homeTeamPainter,
                            contentDescription = fixture.teams.first.name,
                            Modifier
                                .size(spacing.spaceLarge)
                                .padding(spacing.spaceExtraSmall)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        Text(text = fixture.teams.first.name)
                    }

                    Text(
                        text = homeGoals,
                        style = MaterialTheme.typography.titleSmall
                    )
                }

                Spacer(modifier = Modifier.height(spacing.spaceDefault))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = awayTeamPainter,
                            contentDescription = fixture.teams.first.name,
                            Modifier
                                .size(spacing.spaceLarge)
                                .padding(spacing.spaceExtraSmall)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        Text(text = fixture.teams.second.name)
                    }

                    Text(
                        text = awayGoals,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {

    InstantScoreTheme() {
        FixtureCard(
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
                    countryFlag = "", season = 2023
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
            ),
            onClickFixtureCard = {}
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MatchCardPreviewDark() {

    InstantScoreTheme() {
        InstantScoreTheme() {
            FixtureCard(
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
                        countryFlag = "",
                        season = 2024
                    ),
                    teams = Pair(
                        Team(name = "Brest", logo = ""),
                        Team(name = "Lyon", logo = "")
                    ),
                    goals = Goal(
                        homeTeamScore = 5,
                        awayTeamScore = 3
                    ),
                    startTime = 1672774200
                ),
                onClickFixtureCard = {}
            )
        }
    }
}