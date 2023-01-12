package com.uxstate.instantscore.presentation.screens.details_screen.components.lineup

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixture_details.Player
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun PlayerCard(player: Player, modifier: Modifier = Modifier, teamColor: Color = Color.LightGray) {
    val spacing = LocalSpacing.current

    Row(
        horizontalArrangement = Arrangement.spacedBy(spacing.spaceMedium),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(spacing.spaceExtraSmall)
    ) {

        Box() {
            Icon(
                painter = painterResource(id = R.drawable.shirt_black),
                contentDescription = player.playerName,
                modifier = modifier.size(spacing.spaceLarge),
                tint = teamColor
            )

            Text(
                text = player.playerNumber.toString(),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(spacing.spaceExtraSmall)
            )
        }

        Text(
            text = player.playerName,
            fontWeight = FontWeight.SemiBold,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

@Preview
@Composable
fun PlayerCardPreview() {

    val player =
        Player(playerId = 0, playerName = "Tonnie Von", playerNumber = 13, playerPosition = "M")

    InstantScoreTheme() {
        PlayerCard(player = player, teamColor = Color.Blue)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PlayerCardPreviewDark() {

    val player =
        Player(playerId = 0, playerName = "Tonnie Von", playerNumber = 13, playerPosition = "M")

    InstantScoreTheme() {
        PlayerCard(player = player, teamColor = Color.White)
    }
}