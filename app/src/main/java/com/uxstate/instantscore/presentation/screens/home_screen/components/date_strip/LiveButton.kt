package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun LiveButton(onClickLiveButton: () -> Unit, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    val transition = rememberInfiniteTransition()
    val alpha by transition.animateFloat(
        initialValue = 1f,
        targetValue = .7f,
        animationSpec = InfiniteRepeatableSpec(
            animation = tween(
                durationMillis = 3_000,
                easing = FastOutSlowInEasing
            ),
            repeatMode = RepeatMode.Reverse
        )

    )

    Button(
        onClick = { onClickLiveButton() },

        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Red.copy(alpha = alpha),

        )
    ) {
        Text(
            text = stringResource(id = R.string.live_text),
            modifier = Modifier
                .background(Color.Red.copy(alpha = alpha))

        )
    }
}

@Preview
@Composable
fun LiveButtonPreview() {

    InstantScoreTheme() {
        LiveButton(onClickLiveButton = { })
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun LiveButtonPreviewDark() {

    InstantScoreTheme() {
        LiveButton(onClickLiveButton = { })
    }
}