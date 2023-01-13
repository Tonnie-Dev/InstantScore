package com.uxstate.instantscore.presentation.screens.details_screen.components.lineup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.Coach
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.fromHex

@Composable
fun LineUpBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {

    val homeLineUp = fixtureDetails.lineUps[0]
    val homeColor = Color.fromHex(homeLineUp.teamColor)
    val awayLineUp = fixtureDetails.lineUps[1]
    val awayColor = Color.fromHex(awayLineUp.teamColor)
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
    ) {


        StartingElevenCard(fixtureDetails = fixtureDetails)
        Text(
                text = "Substitutes",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Black,
                modifier = Modifier.padding(
                        horizontal = spacing.spaceMedium + spacing.spaceSmall
                )
        )
        SubstitutesCard(fixtureDetails = fixtureDetails)

        Text(
                text = "Coach",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Black
        )
        CoachesCard(fixtureDetails = fixtureDetails)

    }
}
