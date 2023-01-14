package com.uxstate.instantscore.presentation.screens.details_screen.components.stats

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StatsBar(
    statValue: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.LightGray,
    highlightColor: Color = Color.Magenta
) {

    val spacing = LocalSpacing.current
    var statFraction by remember { mutableStateOf(statValue / 100f) }

    Box(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(spacing.spaceSmall)
            )
            .clip(RoundedCornerShape(spacing.spaceSmall))
            .fillMaxWidth()
            .padding(spacing.spaceSingleDp)

    ) {

        Row(
            modifier = Modifier
                .background(
                    color = highlightColor,
                    shape = RoundedCornerShape(spacing.spaceSmall)
                )
                .clip(RoundedCornerShape(spacing.spaceSmall))
                .fillMaxWidth(statFraction)
                .padding(horizontal = spacing.spaceSmall),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                text = statValue.toString(),
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        }
    }
}

@Preview()
@Composable
fun StatsBarPreview() {

    InstantScoreTheme() {
        StatsBar(statValue = 41)
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun StatsBarPreviewDark() {

    InstantScoreTheme() {
        StatsBar(statValue = 58)
    }
}