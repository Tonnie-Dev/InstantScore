package com.uxstate.instantscore.presentation.screens.standings_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.models.standings.Team
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme

@Composable
fun StandingTable(standings: List<Standing>, modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {

        item {
            StandingHeader()
        }

        items(standings) { standing ->

            StandingRow(standing = standing)
        }
    }
}



@Preview
@Composable
fun StandingTablePreview() {
    val standing = Standing(
        description = "Promotion",
        goalsAgainst = 23,
        goalsFor = 47,
        goalsDiff = 24,
        matchPlayed = 21,
        group = "Group E",
        points = 64,
        rank = 3,
        team = Team(
            id = 96,
            name = "Tonnie FC",
            logo = ""
        ),


    )
    val standings = List(20) { standing }

    InstantScoreTheme {

        StandingTable(standings = standings)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StandingTablePreviewDark() {
    val standing = Standing(
        description = "Promotion",
        goalsAgainst = 23,
        goalsFor = 47,
        goalsDiff = 24,
        matchPlayed = 21,
        group = "Group E",
        points = 64,
        rank = 3,
        team = Team(
            id = 96,
            name = "Tonnie FC",
            logo = ""
        ),


    )
    val standings = List(20) { standing }

    InstantScoreTheme {

        StandingTable(standings = standings)
    }
}
