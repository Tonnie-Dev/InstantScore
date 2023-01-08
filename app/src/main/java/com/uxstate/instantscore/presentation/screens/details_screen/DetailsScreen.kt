package com.uxstate.instantscore.presentation.screens.details_screen

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailsScreen(fixtureId: Int, viewModel: DetailsViewModel = hiltViewModel()) {
    val context = LocalContext.current
    val state by viewModel.fakeState.collectAsState()

    Toast.makeText(context, "The id is: $state", Toast.LENGTH_SHORT).show()
}