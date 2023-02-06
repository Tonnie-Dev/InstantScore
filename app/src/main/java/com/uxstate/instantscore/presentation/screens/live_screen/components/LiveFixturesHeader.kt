package com.uxstate.instantscore.presentation.screens.live_screen.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme

@Composable
fun LiveFixturesHeader(modifier: Modifier = Modifier) {
Card(shape = RectangleShape) {
    Text(
            text = stringResource(R.string.live_fixtures_text),
            style = MaterialTheme.typography.displaySmall,
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
    )
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