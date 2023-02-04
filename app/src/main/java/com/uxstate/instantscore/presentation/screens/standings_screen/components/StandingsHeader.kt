package com.uxstate.instantscore.presentation.screens.standings_screen.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StandingsHeader(league: League, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val countryFlagPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(league.countryFlag)
            .decoderFactory(SvgDecoder.Factory())
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
    

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(horizontalAlignment = Alignment.Start, modifier = Modifier.clickable {  }) {


                Image(
                    painter = leagueLogoPainter,
                    contentDescription = stringResource(R.string.league_logo_string),
                    modifier = Modifier.size(spacing.spaceExtraLarge + spacing.spaceSmall),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = league.name,
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = countryFlagPainter,
                    contentDescription = stringResource(R.string.country_flag_text),
                    modifier = Modifier.size(spacing.spaceLarge),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = league.country,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = league.season.toString(),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun StandingsHeaderPreview() {
    val league = League(
        id = 26,
        name = "English Premier League",
        country = "England",
        leagueLogo = "",
        countryFlag = "",
        season = 2022
    )

    InstantScoreTheme() {
        StandingsHeader(league = league)
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun StandingsHeaderPreviewDark() {
    val league = League(
        id = 26,
        name = "English Premier League",
        country = "England",
        leagueLogo = "",
        countryFlag = "",
        season = 2022
    )

    InstantScoreTheme() {
        StandingsHeader(league = league)
    }
}