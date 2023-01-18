package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
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

    Surface(
        modifier = modifier
            .clickable { onClickLiveButton() }
            .padding(spacing.spaceExtraSmall),
        shape = RoundedCornerShape(spacing.spaceExtraSmall),
        color = Color.Red.copy(alpha = alpha),
        shadowElevation = spacing.spaceSmall
    ) {
        Text(
            text = stringResource(id = R.string.live_text),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(spacing.spaceExtraSmall)
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