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

@Composable
fun LineUpBoard(fixtureDetails: FixtureDetails, modifier: Modifier = Modifier) {

    val homeLineUp = fixtureDetails.lineUps[0]
    val awayLineUp = fixtureDetails.lineUps[1]
    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
    ) {

        Row() {

            // Home Column
            Column(verticalArrangement = Arrangement.spacedBy(spacing.spaceMedium)) {
                homeLineUp.startingXI.forEach { player -> PlayerCard(player = player) }

                Text(
                    text = "Substitutes",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Black
                )

                homeLineUp.substitutes.forEach { player -> PlayerCard(player = player) }

                Text(
                    text = "Coach",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Black
                )

                CoachPortrait(coach = homeLineUp.coach)
            }

            // away column
            Column() {
                awayLineUp.startingXI.forEach { player -> PlayerCard(player = player) }

                Text(
                    text = "Substitutes",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Black
                )

                awayLineUp.substitutes.forEach { player -> PlayerCard(player = player) }

                Text(
                    text = "Coach",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Black
                )
                CoachPortrait(coach = awayLineUp.coach)
            }
        }
    }
}

@Composable
fun CoachPortrait(coach: Coach, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    val spacing = LocalSpacing.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(coach.photo)
            .error(R.drawable.empty_face)
            .placeholder(R.drawable.empty_face)
            .crossfade(true)
            .build()
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painter,
            contentDescription = coach.name,
            modifier = Modifier
                .size(spacing.spaceLarge)
                .clip(
                    CircleShape
                )
                .border(
                    width = spacing.spaceSingleDp,
                    color = Color.Gray,
                    shape = CircleShape
                )
        )
        Text(
            text = coach.name,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Black
        )
    }
}

@Preview
@Composable
fun CoachPortraitPreview() {
    val coach = Coach(name = "Mourinho", photo = "")

    InstantScoreTheme() {
        CoachPortrait(coach = coach)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun CoachPortraitPreviewDark() {
    val coach = Coach(name = "Mourinho", photo = "")

    InstantScoreTheme() {
        CoachPortrait(coach = coach)
    }
}