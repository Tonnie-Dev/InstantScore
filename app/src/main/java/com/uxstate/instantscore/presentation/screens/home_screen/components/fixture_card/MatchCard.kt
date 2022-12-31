package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team
import com.uxstate.instantscore.presentation.screens.common_components.HorizontalTeamLogo
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun MatchCard(fixture: Fixture, modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val homeTeamPainter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(context = context)
                    .data(fixture.teams.first)
                    .error(R.drawable.empty_logo)
    )

    Card(modifier = modifier) {


        Row() {
            Text(text = fixture.status.fixtureShort)

            Column() {
                Row() {

                }
            }
        }
        Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall)
        ) {
            HorizontalTeamLogo(team = fixture.teams.first)
            Surface(

                    border = BorderStroke(
                            width = spacing.spaceHalfDp,
                            color = MaterialTheme.colorScheme.onSurface
                    ),
                    modifier = Modifier.padding(spacing.spaceExtraSmall)
            ) {
                Text(text = fixture.date.toString())
            }
            HorizontalTeamLogo(team = fixture.teams.second)
        }
    }
}

@Preview
@Composable
fun MatchCardPreview() {

    MatchCard(
            fixture = FixtureBonoko(
                    fixtureId = 0,
                    date = 1000,
                    status = Status(
                            fixtureLong = "",
                            fixtureShort = "",
                            timeElapsed = 0
                    ),
                    teams = Pair(
                            Team(name = "Brentford", logo = ""),
                            Team(name = "Arsenal", logo = "")
                    )
            )
    )
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun MatchCardPreviewDark() {

    InstantScoreTheme() {
        MatchCard(
                fixture = FixtureBonoko(
                        fixtureId = 0,
                        date = 1000,
                        status = Status(
                                fixtureLong = "",
                                fixtureShort = "",
                                timeElapsed = 0
                        ),
                        teams = Pair(
                                Team(name = "Brentford", logo = ""),
                                Team(name = "Arsenal", logo = "")
                        )
                )
        )
    }
}