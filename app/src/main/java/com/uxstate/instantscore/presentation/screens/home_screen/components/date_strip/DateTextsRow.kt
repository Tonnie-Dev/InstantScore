package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.toStringDate
import java.time.LocalDate

@Composable
fun DateTextsRow(
    modifier: Modifier = Modifier,
    onDateChange: (formattedStringDate: String) -> Unit
) {

    var selectedIndex by remember { mutableStateOf(2) }

    // 5 DateTexts row

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {

        DateText(
                dateTextIndex = 0,
                onDateTextClick = {
                    selectedIndex = 0
                    onDateChange(it.toStringDate())
                },
                isSelected = selectedIndex == 0
        )
        DateText(
                dateTextIndex = 1,
                onDateTextClick = {
                    selectedIndex = 1
                    onDateChange(it.toStringDate())
                },
                isSelected = selectedIndex == 1

        )
        DateText(
                dateTextIndex = 2,
                onDateTextClick = {
                    selectedIndex = 2
                    onDateChange(it.toStringDate())
                },
                isSelected = selectedIndex == 2
        )
        DateText(
                dateTextIndex = 3,
                onDateTextClick = {
                    selectedIndex = 3
                    onDateChange(it.toStringDate())
                },
                isSelected = selectedIndex == 3
        )
        DateText(
                dateTextIndex = 4,
                onDateTextClick = {
                    selectedIndex = 4
                    onDateChange(it.toStringDate())
                },
                isSelected = selectedIndex == 4
        )
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