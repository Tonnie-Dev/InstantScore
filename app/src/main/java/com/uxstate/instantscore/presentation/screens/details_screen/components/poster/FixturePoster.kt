package com.uxstate.instantscore.presentation.screens.details_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.*
import com.uxstate.instantscore.presentation.screens.details_screen.components.poster.DetailsScoreCard
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun FixturePoster(details: FixtureDetails, onClickBackButton: () -> Unit) {

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

        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.back_label),
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(spacing.spaceLarge + spacing.spaceMedium)
                .clickable { onClickBackButton() }
                .padding(spacing.spaceSmall)
        )

        DetailsScoreCard(
            details = details,
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
                    first = com.uxstate.instantscore.domain.models.fixture_details.Team(
                        name = "Liverpool",
                        logo = "",
                        isWinner = false
                    ),
                    second = com.uxstate.instantscore.domain.models.fixture_details.Team(
                        name = "",
                        logo = "",
                        isWinner = false
                    )
                ),
                events = listOf(),
                lineUps = listOf(),
                score = Score(
                    extraTimeScore = ExtraTime(
                        extraTimeAwayScore = 0,
                        extraTimeHomeScore = 0
                    ),
                    fullTimeScore = FullTime(
                        fullTimeAwayScore = 0,
                        fullTimeHomeScore = 0
                    ),
                    penaltyShootOutScore = PenaltyShootOut(
                        penaltiesScoredAway = 0,
                        penaltiesScoredHome = 0
                    )
                ),
                stats = listOf()
            )
        ) {}
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun FixturePosterPreviewDark() {
    InstantScoreTheme() {
        FixturePoster(
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
                    first = com.uxstate.instantscore.domain.models.fixture_details.Team(
                        name = "Liverpool",
                        logo = "",
                        isWinner = false
                    ),
                    second = com.uxstate.instantscore.domain.models.fixture_details.Team(
                        name = "",
                        logo = "",
                        isWinner = false
                    )
                ),
                events = listOf(),
                lineUps = listOf(),
                score = Score(
                    extraTimeScore = ExtraTime(
                        extraTimeAwayScore = 0,
                        extraTimeHomeScore = 0
                    ),
                    fullTimeScore = FullTime(
                        fullTimeAwayScore = 0,
                        fullTimeHomeScore = 0
                    ),
                    penaltyShootOutScore = PenaltyShootOut(
                        penaltiesScoredAway = 0,
                        penaltiesScoredHome = 0
                    )
                ),
                stats = listOf()
            )
        ) {}
    }
}