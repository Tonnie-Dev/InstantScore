package com.uxstate.instantscore.presentation.screens.details_screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailsScreen(fixtureId: Int) {
    val context = LocalContext.current
    Toast.makeText(context, "The id is: $fixtureId", Toast.LENGTH_SHORT)
        .show()
}