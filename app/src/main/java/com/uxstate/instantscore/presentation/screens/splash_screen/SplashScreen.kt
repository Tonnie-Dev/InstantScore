package com.uxstate.instantscore.presentation.screens.splash_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.screens.destinations.HomeScreenDestination
import com.uxstate.instantscore.utils.LocalSpacing
@Destination
@RootNavGraph(start = true)
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {

    val spacing = LocalSpacing.current
    val spec = LottieCompositionSpec.RawRes(R.raw.soccer_splash)
    val composition by rememberLottieComposition(spec = spec)
    val state = animateLottieCompositionAsState(composition = composition)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        LottieAnimation(
            composition = composition, progress = { state.progress },

        )

        if (state.isAtEnd && state.isPlaying) {

            navigator.navigate(HomeScreenDestination)
        }
    }
}