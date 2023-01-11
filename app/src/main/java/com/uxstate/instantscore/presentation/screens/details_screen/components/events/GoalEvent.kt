package com.uxstate.instantscore.presentation.screens.details_screen.components.events

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun GoalEvent(event: Event, isHomeTeamEvent: Boolean, modifier: Modifier = Modifier) {
    if (isHomeTeamEvent) {

        HomeGoalEvent(event = event, modifier = modifier)
    } else {

        AwayGoalEvent(event = event, modifier = modifier)
    }
}

@Composable
fun HomeGoalEvent(event: Event, modifier: Modifier = Modifier) {

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

        Image(
            painter = painterResource(id = R.drawable.ic_ball),
            contentDescription = "",
            modifier = Modifier.size(spacing.spaceSmall * 3)
        )

        Column() {
            Text(
                text = event.player,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Text(text = event.assist, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun AwayGoalEvent(event: Event, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall)
    ) {

        Column() {
            Text(
                text = event.player,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold
            )
            Text(text = event.assist, style = MaterialTheme.typography.bodySmall)
        }
        Spacer(modifier = Modifier.width(spacing.spaceMedium))
        Image(
            painter = painterResource(id = R.drawable.ic_ball),
            contentDescription = "",
            modifier = Modifier.size(spacing.spaceSmall * 3)
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
fun HomeGoalEventPreview() {

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
        HomeGoalEvent(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeGoalEventPreviewDark() {

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
        HomeGoalEvent(event = event)
    }
}

@Preview
@Composable
fun AwayGoalEventPreview() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "De Bruyne",
        side = "",
        assist = "Leloy Sane",
        eventType = "",
        eventDetail = ""
    )

    InstantScoreTheme() {
        AwayGoalEvent(event = event)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun AwayGoalEventPrevDarkiew() {

    val event = Event(
        timeElapsed = 87,
        inExtra = 0,
        player = "De Bruyne",
        side = "",
        assist = "Leloy Sane",
        eventType = "",
        eventDetail = ""
    )

    InstantScoreTheme() {
        AwayGoalEvent(event = event)
    }
}
