package com.uxstate.instantscore.presentation.screens.stats_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme

@Composable
fun PlayerStatsList(
    stats: List<PlayerStats>,
    modifier: Modifier = Modifier
) {
    LazyColumn(content = {
        items(stats) {
            PlayerStatCard(
                playerStats = it
            )
        }
    })
}

@Preview
@Composable
fun PlayerStatsListPreview() {
    val stats = List(20) {
        PlayerStats(
            rank = 23,
            playerName = "Gideon",
            playerPhoto = "",
            teamName = "Arsenal",
            teamLogo = "",
            goals = 5,
            assists = 10,
            yellowCards = 3,
            redCards = 0
        )
    }
    InstantScoreTheme {
        PlayerStatsList(
            stats = stats
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerStatsListPreviewDark() {

    val stats = List(20) {
        PlayerStats(
            rank = 23,
            playerName = "Gideon",
            playerPhoto = "",
            teamName = "Arsenal",
            teamLogo = "",
            goals = 5,
            assists = 10,
            yellowCards = 3,
            redCards = 0
        )
    }

    InstantScoreTheme {
        PlayerStatsList(
            stats = stats
        )
    }
}