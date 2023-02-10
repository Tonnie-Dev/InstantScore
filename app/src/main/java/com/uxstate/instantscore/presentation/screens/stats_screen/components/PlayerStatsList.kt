package com.uxstate.instantscore.presentation.screens.stats_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme

@Composable
fun PlayerStatsList(
    player: String,
    teamName: String,
    teamLogo: String,
    rank: Int,
    statValue: Int,
    modifier: Modifier = Modifier
) {
    LazyColumn(content = {
        items(20) {
            PlayerStatCard(
                player = player,
                teamName = teamName,
                teamLogo = teamLogo,
                rank = rank,
                statValue = statValue
            )
        }
    })
}

@Preview
@Composable
fun PlayerStatsListPreview() {

    InstantScoreTheme {
        PlayerStatsList(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            rank = 1,
            statValue = 20
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerStatsListPreviewDark() {

    InstantScoreTheme {
        PlayerStatsList(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            rank = 1,
            statValue = 20
        )
    }
}