package com.uxstate.instantscore.presentation.screens.details_screen.components.lineup

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun CoachPortraitCard(
    coach: Coach,
    modifier: Modifier = Modifier,
    teamColor: Color = Color.LightGray
) {

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
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.padding(spacing.spaceSmall)
    ) {

        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Image(
            painter = painter,
            contentDescription = coach.name,
            modifier = Modifier
                .size(spacing.spaceExtraLarge)
                .clip(
                    CircleShape
                )
                .border(
                    width = spacing.spaceSingleDp,
                    color = teamColor,
                    shape = CircleShape
                )

            // .padding(spacing.spaceSmall)
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
        CoachPortraitCard(coach = coach)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun CoachPortraitPreviewDark() {
    val coach = Coach(name = "Mourinho", photo = "")

    InstantScoreTheme() {
        CoachPortraitCard(coach = coach)
    }
}