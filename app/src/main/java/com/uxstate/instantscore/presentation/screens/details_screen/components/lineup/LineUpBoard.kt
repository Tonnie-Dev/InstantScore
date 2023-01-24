package com.uxstate.instantscore.presentation.screens.details_screen.components.lineup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun LineUpBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {

        StartingElevenCard(fixtureDetails = fixtureDetails)
        Text(
            text = stringResource(R.string.substitutes_label),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(
                horizontal = spacing.spaceMedium + spacing.spaceSmall
            )
        )
        SubstitutesCard(fixtureDetails = fixtureDetails)

        Text(
            text = stringResource(R.string.coaches_label),
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Black,
            modifier = Modifier.padding(
                horizontal = spacing.spaceMedium + spacing.spaceSmall
            )
        )
        CoachesCard(fixtureDetails = fixtureDetails)
    }
}

@Preview
@Composable
fun LineUpBoardPrev() {

    InstantScoreTheme() {
        val fixtureDetails = FixtureDetails(
            fixtureId = -1,
            timeStamp = 0L,
            referee = "",
            venue = "",
            status = "",
            timeElapsed = -1,
            homeGoals = -1,
            awayGoals = -1,
            leagueName = "",
            teams = Pair(
                first = Team(
                    name = "",
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

        LineUpBoard(fixtureDetails = fixtureDetails)
    }
}
