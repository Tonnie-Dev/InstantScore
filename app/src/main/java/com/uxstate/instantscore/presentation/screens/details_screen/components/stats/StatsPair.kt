package com.uxstate.instantscore.presentation.screens.details_screen.components.stats

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StatsPair(
    statType: String,
    homeStatValue: Int,
    awayStatValue: Int,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Surface(modifier = modifier.padding(vertical = spacing.spaceSmall)) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = spacing.spaceSmall)
        ) {

            Text(
                text = statType,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Medium
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
                modifier = Modifier.padding(
                    horizontal = spacing.spaceMedium,
                    vertical = spacing.spaceSmall
                )
            ) {

                Row(modifier = Modifier.weight(.5f)) {
                    // Home Stat Bar
                    StatsBar(statValueA = homeStatValue, statValueB = awayStatValue)
                }

                Row(modifier = Modifier.weight(.5f)) {
                    // Away Stat Bar

                    StatsBar(statValueA = awayStatValue, statValueB = homeStatValue)
                }
            }
        }
    }
}

@Preview()
@Composable
fun StatsPairPreview() {

    InstantScoreTheme() {
        StatsPair(statType = "Ball Possession", homeStatValue = 43, awayStatValue = 57)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StatsPairPreviewDark() {

    InstantScoreTheme() {
        StatsPair(statType = "Ball Possession", homeStatValue = 43, awayStatValue = 57)
    }
}