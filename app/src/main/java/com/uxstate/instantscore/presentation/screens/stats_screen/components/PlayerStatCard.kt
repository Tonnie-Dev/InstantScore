package com.uxstate.instantscore.presentation.screens.stats_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
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
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun PlayerStatCard(
    player: String,
    teamName: String,
    teamLogo: String,
    rank: Int,
    statValue: Int,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Card(modifier = modifier, shape = RectangleShape) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth().padding(spacing.spaceExtraSmall),
        ) {

            Text(text = rank.toString(), style = MaterialTheme.typography.bodySmall)
            PlayerTeamRow(player = player, teamName = teamName, teamLogo = teamLogo)
            Text(text = statValue.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun PlayerTeamRow(
    player: String,
    teamName: String,
    teamLogo: String,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(teamLogo)
            .crossfade(true)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .build()
    )
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.team_logo_image),
            modifier = Modifier.size(spacing.spaceMedium + spacing.spaceSmall)
        )

        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Column() {

            Text(
                text = player,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = player,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}

@Preview
@Composable
fun StatsPlayerCardPreview() {
    InstantScoreTheme() {
        PlayerStatCard(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            rank = 13,
            statValue = 17,
            modifier = Modifier
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StatsPlayerCardPreviewDark() {
    InstantScoreTheme() {
        PlayerStatCard(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            rank = 13,
            statValue = 17,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun PlayerTeamRowPreview() {
    InstantScoreTheme() {
        PlayerTeamRow(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            modifier = Modifier
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerTeamRowPreviewDark() {
    InstantScoreTheme() {
        PlayerTeamRow(
            player = "Gideon",
            teamName = "Arsenal FC",
            teamLogo = "",
            modifier = Modifier
        )
    }
}
