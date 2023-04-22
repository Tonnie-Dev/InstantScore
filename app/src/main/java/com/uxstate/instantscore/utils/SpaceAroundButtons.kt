package com.uxstate.instantscore.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceAroundButtons() {

    Row(modifier = Modifier.background(Color.Cyan).wrapContentSize()) {
        CompositionLocalProvider(LocalMinimumInteractiveComponentEnforcement provides false) {}

        Button(onClick = { }) {
            Text(text = "Hello")
        }
        Button(onClick = { }) {
            Text(text = "Hello")
        }
    }
}

@Preview
@Composable
fun SpaceAroundButtonsPreview() {
    SpaceAroundButtons()
}
