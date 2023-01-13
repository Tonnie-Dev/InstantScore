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
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
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
