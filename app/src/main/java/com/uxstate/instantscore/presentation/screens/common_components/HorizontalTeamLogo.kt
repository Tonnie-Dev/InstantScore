package com.uxstate.instantscore.presentation.screens.common_components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures.Team
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun HorizontalTeamLogo(team: Team, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    val context = LocalContext.current

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(team.logo)
            .placeholder(R.drawable.empty_logo)
            .error(R.drawable.empty_logo)
            .crossfade(true)
            .build()
    )

    Row(modifier = modifier, verticalAlignment = CenterVertically) {

        Image(
            painter = painter,
            contentDescription = team.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(spacing.spaceExtraLarge)
                .padding(spacing.spaceExtraSmall)
        )

        Text(text = team.name, style = MaterialTheme.typography.labelLarge)
    }
}

@Preview
@Composable
fun HorizontalTeamLogoPreview() {

    HorizontalTeamLogo(team = Team(name = "Liverpool", logo = "", goalScored = 7))
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HorizontalTeamLogoPreviewDark() {

    InstantScoreTheme() {
        HorizontalTeamLogo(team = Team(name = "Liverpool", logo = "", goalScored = 7))
    }
}