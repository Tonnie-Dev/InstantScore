package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import java.time.LocalDate

@Composable
fun DateText(
    date: LocalDate,
    dateText: String,
    onClickListener: (localDate: LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    highlightColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {

    val dayDate = date.dayOfWeek

    Column(modifier = modifier.clickable { }) {
        Text(
            text = dateText,
            style = MaterialTheme.typography.titleMedium,
            color = if (isSelected) highlightColor else textColor
        )
        Text(
            text = dateText,
            style = MaterialTheme.typography.labelSmall,
            color = if (isSelected) highlightColor else textColor
        )
    }
}