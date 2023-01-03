package com.uxstate.instantscore.presentation.screens.details_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun FixturePoster(fixture: Fixture) {

    val spacing = LocalSpacing.current
    Box(contentAlignment = Alignment.TopCenter) {

        Image(
            painter = painterResource(R.drawable.fixture_background_one),
            contentDescription = stringResource(
                R.string.stadium_background
            ),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 2f),

            contentScale = ContentScale.Crop
        )

        DetailsScoreCard(
            fixture = fixture,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun FixturePosterPreview() {
    InstantScoreTheme() {
        FixturePoster(
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
fun FixturePosterPreviewDark() {
    InstantScoreTheme() {
        FixturePoster(
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