package com.uxstate.instantscore.presentation.screens.live_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun LiveFixturesHeader(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    Card(shape = RectangleShape) {
        Row(
                modifier = modifier
                        .fillMaxWidth()
                        .padding(spacing.spaceSmall),
                verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(id = R.string.back_label),
                    modifier = Modifier
                            .size(spacing.spaceLarge)
                            .weight(.1f),
                    tint = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.width(spacing.spaceLarge))
            Text(
                    text = stringResource(R.string.live_fixtures_text),
                    style = MaterialTheme.typography.displaySmall,
                    modifier = Modifier.weight(.9f),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview
@Composable
fun LiveFixturesHeaderPreview() {
    InstantScoreTheme() {
        LiveFixturesHeader()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LiveFixturesHeaderPreviewDark() {
    InstantScoreTheme() {
        LiveFixturesHeader()
    }
}