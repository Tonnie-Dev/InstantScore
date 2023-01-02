package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import timber.log.Timber

@Composable
fun LeagueHeader(league: League, modifier: Modifier = Modifier) {

    Timber.i("The flag url is ${league.countryFlag}")
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    // val url = league.countryFlag.toUri().buildUpon().scheme("https").build()
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceSmall)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(context = context)
                    .data(league.leagueLogo)
                    .decoderFactory(SvgDecoder.Factory())
                    .error(R.drawable.empty_flag)
                    .placeholder(R.drawable.empty_logo)
                    .build()
            )

            Image(
                painter = painter,
                contentDescription = league.name,
                modifier = Modifier.size(spacing.spaceSmall * 4).padding(spacing.spaceExtraSmall),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(spacing.spaceSmall * 2))
            Column() {

                Text(text = league.name, style = MaterialTheme.typography.titleSmall)
                Text(text = league.country, style = MaterialTheme.typography.bodySmall)
            }
        }

        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "",
            modifier = Modifier
                .clickable { }
                .align(Alignment.CenterEnd)

        )
    }
}

@Preview
@Composable
fun LeagueHeaderPreview() {
    InstantScoreTheme {

        LeagueHeader(
            league = League(
                id = 13,
                name = "Premier League",
                country = "Kenya",
                leagueLogo = "",
                countryFlag = ""
            )
        )
    }
}

@Preview
@Composable
fun LeagueHeaderPreviewDark() {
    InstantScoreTheme {

        LeagueHeader(
            league = League(
                id = 7,
                name = "E-League",
                country = "Ethiopia",
                leagueLogo = "",
                countryFlag = ""
            )
        )
    }
}