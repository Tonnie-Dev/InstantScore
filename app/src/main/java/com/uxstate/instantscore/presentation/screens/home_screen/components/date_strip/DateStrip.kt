package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import java.time.LocalDate

@Composable
fun DateStrip(
    onDateChange: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LiveButton(onClickLiveButton = {})
        DateTextsRow(onDateChange = onDateChange)
        DatePickerItem(onDateChange = onDateChange)
    }
}