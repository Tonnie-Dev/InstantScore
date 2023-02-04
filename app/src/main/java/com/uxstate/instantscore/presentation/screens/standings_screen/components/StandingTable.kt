package com.uxstate.instantscore.presentation.screens.standings_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.standings.League
import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.models.standings.Team
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingTable(standings: List<Standing>, modifier: Modifier = Modifier) {

    LazyColumn {

        item {
            StandingHeader()
        }

        items(standings) { standing ->

            StandingRow(standing = standing)
        }
    }
}

@Composable
fun StandingTableHeader(league: League, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val countryFlagPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(league.countryFlag)
            .crossfade(true)
            .placeholder(R.drawable.empty_flag)
            .error(R.drawable.empty_flag)
            .build()
    )
    val leagueLogoPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(league.leagueLogo)
            .crossfade(true)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .build()

    )
    Card(modifier = modifier.padding(spacing.spaceSmall), shape = RectangleShape) {
        Row() {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = countryFlagPainter,
                    contentDescription = stringResource(R.string.country_flag_text),
                    modifier = Modifier.size(spacing.spaceLarge)
                )
                Spacer(modifier = Modifier.width(spacing.spaceSmall))
                Text(
                    text = league.country,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = leagueLogoPainter,
                contentDescription = stringResource(R.string.league_logo_string),
                modifier = Modifier.size(spacing.spaceExtraLarge)
            )

            Column {
                Text(
                    text = league.name,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(text = league.season.toString(), style = MaterialTheme.typography.titleMedium)
            }
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

        league = League(
            id = 0,
            name = "English Premier League",
            country = "England",
            leagueLogo = "",
            countryFlag = "",
            season = 2023
        )
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

        league = League(
            id = 0,
            name = "English Premier League",
            country = "England",
            leagueLogo = "",
            countryFlag = "",
            season = 2023
        )
    )
    val standings = List(20) { standing }

    InstantScoreTheme {

        StandingTable(standings = standings)
    }
}
@Preview
@Composable
fun TableHeaderPreview() {
    val league = League(
        id = 26,
        name = "English Premier League",
        country = "England",
        leagueLogo = "",
        countryFlag = "",
        season = 2022
    )

    InstantScoreTheme() {
        StandingTableHeader(league = league)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TableHeaderPreviewDark() {
    val league = League(
        id = 26,
        name = "English Premier League",
        country = "England",
        leagueLogo = "",
        countryFlag = "",
        season = 2022
    )

    InstantScoreTheme() {
        StandingTableHeader(league = league)
    }
}