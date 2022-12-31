package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import java.time.LocalDate

@Composable
fun DateTextsRow(
    modifier: Modifier = Modifier,
    onDateChange: (date: LocalDate) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(2) }

    // 5 DateTexts row
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {

        (0..4).forEach { i ->

            val isSelected = (i == selectedIndex)
            DateText(dateTextIndex = i, onDateTextClick = {
                selectedIndex = i

                if (isSelected) {

                    onDateChange(it)
                }
            }, isSelected = isSelected)
        }
    }
}

@Preview
@Composable
fun DateTextsRowPreview() {

    InstantScoreTheme() {
        DateTextsRow(onDateChange = {})
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DateTextsRowPreviewDark() {

    InstantScoreTheme() {
        DateTextsRow(onDateChange = {})
    }
}