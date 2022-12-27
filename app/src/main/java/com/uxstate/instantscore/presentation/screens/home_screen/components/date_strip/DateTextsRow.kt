package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier

import java.time.LocalDate

@Composable
fun DateTextsRow(modifier: Modifier = Modifier, localDate: LocalDate = LocalDate.now()) {

    var selectedIndex by remember { mutableStateOf(2)}
    //5 DateTexts row


}