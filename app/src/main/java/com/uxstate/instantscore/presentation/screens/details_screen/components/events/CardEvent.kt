package com.uxstate.instantscore.presentation.screens.details_screen.components.events

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun CardEvent(event: Event, isHomeTeamEvent: Boolean, modifier: Modifier = Modifier) {

    if (isHomeTeamEvent) {
        HomeCard(event = event, modifier = modifier)
    } else {
        AwayCard(event = event, modifier = modifier)
    }
}

@Composable
fun HomeCard(
    event: Event,
    modifier: Modifier = Modifier,
    cardColor: Color = Color.Companion.Yellow

) {
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

        Surface(
            color = cardColor,
            tonalElevation = spacing.spaceMedium,
            shadowElevation = spacing.spaceSmall,
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.spaceExtraSmall))
                .background(Color.Yellow)
                .size(
                    width = spacing.spaceExtraSmall * 4,
                    height = spacing.spaceExtraSmall * 5
                ),
            content = {}
        )
        Text(
            text = event.player,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun AwayCard(
    event: Event,
    modifier: Modifier = Modifier,
    cardColor: Color = Color.Companion.Yellow
) {

    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall)
    ) {
        Text(
            text = event.player,
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))

        Surface(
            color = cardColor,
            tonalElevation = spacing.spaceMedium,
            shadowElevation = spacing.spaceSmall,
            modifier = Modifier
                .clip(RoundedCornerShape(spacing.spaceExtraSmall))
                .background(Color.Yellow)
                .size(
                    width = spacing.spaceExtraSmall * 4,
                    height = spacing.spaceExtraSmall * 5
                ),
            content = {}
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Text(
            text = "${event.timeElapsed}'",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
    }
}

@Preview
@Composable
fun HomeCardPreview() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "Baba Ngida",
        side = "",
        assist = "Baba Yoyo",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        HomeCard(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeCardPreviewDark() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "Baba Ngida",
        side = "",
        assist = "Baba Yoyo",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        HomeCard(event = event, cardColor = Color.Red)
    }
}

@Preview
@Composable
fun AwayCardPreview() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "Baba Ngida",
        side = "",
        assist = "Baba Yoyo",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        AwayCard(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AwayCardPreviewDark() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "Baba Ngida",
        side = "",
        assist = "Baba Yoyo",
        eventType = "",
        eventDetail = ""
    )
    InstantScoreTheme() {
        AwayCard(event = event)
    }
}