package com.uxstate.instantscore.presentation.screens.details_screen.components.events

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun SubstitutionEvent(event: Event, modifier: Modifier = Modifier) {
}

@Composable
fun HomeSubstitution(event: Event, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceMedium)
    ) {
        Text(
            text = "${event.timeElapsed}'",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )

        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Sub In",
                    tint = Color.Green
                )

                Text(
                    text = event.player,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Sub In",
                    tint = Color.Red
                )

                Text(
                    text = event.assist,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }
        }
    }
}

@Composable
fun AwaySubstitution(event: Event, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall)
    ) {

        Column() {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Sub In",
                    tint = Color.Green
                )

                Text(
                    text = event.player,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Green
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Sub In",
                    tint = Color.Red
                )

                Text(
                    text = event.assist,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Red
                )
            }
        }

        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Text(
            text = "${event.timeElapsed}'",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun HomeSubstitutionPreview() {

    val event = Event(
        timeElapsed = 13,
        inExtra = 0,
        player = "Trippier",
        side = "",
        assist = "Rashford",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        HomeSubstitution(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeSubstitutionPreviewDark() {

    val event = Event(
        timeElapsed = 13,
        inExtra = 0,
        player = "Trippier",
        side = "",
        assist = "Rashford",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        HomeSubstitution(event = event)
    }
}

@Preview
@Composable
fun AwaySubstitutionPreview() {

    val event = Event(
        timeElapsed = 13,
        inExtra = 0,
        player = "Trippier",
        side = "",
        assist = "Rashford",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {

        AwaySubstitution(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AwaySubstitutionPreviewDark() {

    val event = Event(
        timeElapsed = 13,
        inExtra = 0,
        player = "Trippier",
        side = "",
        assist = "Rashford",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {

        AwaySubstitution(event = event)
    }
}