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
import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun PlayerStatCard(
    playerStats: PlayerStats,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Card(modifier = modifier, shape = RectangleShape) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(spacing.spaceExtraSmall),
        ) {

            PlayerTeamRow(playerStats = playerStats)
            Text(text = playerStats.goals.toString(), style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Composable
fun PlayerTeamRow(
    playerStats: PlayerStats,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val context = LocalContext.current
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(playerStats.playerPhoto)
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
        Text(text = playerStats.rank.toString(), style = MaterialTheme.typography.bodySmall)
        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Image(
            painter = painter,
            contentDescription = stringResource(R.string.team_logo_image),
            modifier = Modifier.size(spacing.spaceMedium + spacing.spaceSmall)
        )

        Spacer(modifier = Modifier.width(spacing.spaceSmall))
        Column() {

            Text(
                text = playerStats.playerName,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )

            Text(
                text = playerStats.teamName,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = ContentAlpha.medium)
            )
        }
    }
}

@Preview
@Composable
fun StatsPlayerCardPreview() {

    val playerStats = PlayerStats(
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
    InstantScoreTheme() {
        PlayerStatCard(
            playerStats = playerStats,
            modifier = Modifier
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StatsPlayerCardPreviewDark() {
    val playerStats = PlayerStats(
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
    InstantScoreTheme() {
        PlayerStatCard(
            playerStats = playerStats,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun PlayerTeamRowPreview() {

    val playerStats = PlayerStats(
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
    InstantScoreTheme() {
        PlayerTeamRow(
            playerStats,
            modifier = Modifier
        )
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerTeamRowPreviewDark() {
    val playerStats = PlayerStats(
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
    InstantScoreTheme() {
        PlayerTeamRow(
            playerStats = playerStats,
            modifier = Modifier
        )
    }
}
