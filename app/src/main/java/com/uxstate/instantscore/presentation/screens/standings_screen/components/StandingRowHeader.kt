package com.uxstate.instantscore.presentation.screens.standings_screen.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingRowHeader(
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    Card(modifier = modifier.padding(spacing.spaceSmall), shape = RectangleShape) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceSmall),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = stringResource(R.string.harsh_text),
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black
            )
            Text(
                text = stringResource(R.string.teams_text),
                modifier = Modifier.weight(.4f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black
            )
            Text(
                text = stringResource(R.string.match_played),
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black
            )
            Text(
                text = "GF:GA",
                modifier = Modifier.weight(.2f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black
            )
            Text(
                text = stringResource(R.string.goal_diff_text),
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
            Text(
                text = stringResource(R.string.points_text),
                modifier = Modifier.weight(.1f),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Black,
                textAlign = TextAlign.Center
            )
        }
    }
}
@Preview
@Composable
fun StandingHeaderPreview() {

    InstantScoreTheme() {
        StandingRowHeader()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StandingHeaderPreviewDark() {

    InstantScoreTheme() {
        StandingRowHeader()
    }
}