package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun DateStrip(onDateChange: (formattedStringDate: String) -> Unit) {
    Row(
            
            verticalAlignment = Alignment.CenterVertically
    ) {
        LiveButton(onClickLiveButton = {})
        DateTextsRow(onDateChange = onDateChange)
        DatePickerItem(onDateChange = onDateChange)
    }
}