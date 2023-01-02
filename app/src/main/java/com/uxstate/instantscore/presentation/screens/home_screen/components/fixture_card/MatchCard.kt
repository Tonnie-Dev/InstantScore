package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun MatchCard(fixture: Fixture, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val homeTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(fixture.teams.first.logo)
            .error(R.drawable.empty_flag)
            .placeholder(R.drawable.empty_flag)
            .crossfade(true)
            .build()
    )

    val awayTeamPainter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context = context)
            .data(fixture.teams.second.logo)
            .error(R.drawable.empty_flag)
            .placeholder(R.drawable.empty_flag)
            .crossfade(true)
            .build()
    )

    Card(
        modifier = modifier.padding(
            vertical = spacing.spaceExtraSmall,
            horizontal = spacing.spaceSmall
        ),
        shape = RectangleShape
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(spacing.spaceExtraSmall)
        ) {
            Text(
                text = fixture.status.fixtureShort,
                modifier = Modifier.align(Alignment.CenterVertically)
            )

            Column(modifier = Modifier.padding(spacing.spaceSmall)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = homeTeamPainter,
                            contentDescription = fixture.teams.first.name,
                            Modifier.size(spacing.spaceExtraSmall * 4)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        Text(text = fixture.teams.first.name)
                    }

                    Text(
                        text = fixture.goals.homeTeamScore.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(spacing.spaceDefault))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Image(
                            painter = awayTeamPainter,
                            contentDescription = fixture.teams.first.name,
                            Modifier.size(spacing.spaceExtraSmall * 4)
                        )
                        Spacer(modifier = Modifier.width(spacing.spaceSmall))
                        Text(text = fixture.teams.second.name)
                    }

                    Text(
                        text = fixture.goals.awayTeamScore.toString(),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {

    InstantScoreTheme() {
        MatchCard(
            fixture = Fixture(
                fixtureId = 0, date = LocalDate.now(),
                status = Status(
                    fixtureLong = "",
                    fixtureShort = "FT",
                    timeElapsed = 63
                ),
                league = League(
                    id = 0,
                    name = "China League",
                    country = "",
                    leagueLogo = "",
                    countryFlag = ""
                ),
                teams = Pair(
                    Team(name = "Auxere", logo = ""),
                    Team(name = "Monaco", logo = "")
                ),
                goals = Goal(
                    homeTeamScore = 5,
                    awayTeamScore = 3
                )
            )
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MatchCardPreviewDark() {

    InstantScoreTheme() {
        InstantScoreTheme() {
            MatchCard(
                fixture = Fixture(
                    fixtureId = 0, date = LocalDate.now(),
                    status = Status(
                        fixtureLong = "",
                        fixtureShort = "FT",
                        timeElapsed = 63
                    ),
                    league = League(
                        id = 0,
                        name = "China League",
                        country = "",
                        leagueLogo = "",
                        countryFlag = ""
                    ),
                    teams = Pair(
                        Team(name = "Brest", logo = ""),
                        Team(name = "Lyon", logo = "")
                    ),
                    goals = Goal(
                        homeTeamScore = 5,
                        awayTeamScore = 3
                    )
                )
            )
        }
    }
}