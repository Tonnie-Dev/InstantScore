package com.uxstate.instantscore.presentation.screens.common_components

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.*

@Composable
fun LottieDefinition(@RawRes lottieRes: Int, modifier: Modifier = Modifier) {
    //spec - points to the raw resource
    //composition - render JSON file
    //state - manipulate state
    //LottieAnimation - display the anim composable


    val spec = LottieCompositionSpec.RawRes(lottieRes)

    val composition by rememberLottieComposition(spec = spec)

    val state by animateLottieCompositionAsState(
            composition = composition,
            iterations = LottieConstants.IterateForever
    )

    LottieAnimation(composition = composition, progress = { state }, modifier = modifier)
}















