package com.uxstate.instantscore.presentation.screens.details_screen.components.events

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun GoalEventComposable(event: Event, isHomeTeamEvent: Boolean) {
    Row() {

    }
}

@Composable
fun HomeGoalEvent(event: Event) {

    val spacing = LocalSpacing.current
    Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
                text = "${event.timeElapsed}'",
                style = MaterialTheme.typography.titleSmall
        )

        Image(
                painter = painterResource(id = R.drawable.ic_ball),
                contentDescription = "",
                modifier = Modifier.size(spacing.spaceMedium)
        )

        Column() {
            Text(text = event.player, style = MaterialTheme.typography.titleSmall)
            Text(text = event.assist, style = MaterialTheme.typography.bodySmall)
        }

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
    
    HomeGoalEvent(event = event)
    
}

