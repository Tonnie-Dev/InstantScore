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
    onDateChange: (formattedStringDate: String) -> Unit
) {

    var selectedIndex by remember { mutableStateOf(2) }
    val date = remember { LocalDate.now() }
    // 5 DateTexts row

    Row(horizontalArrangement = Arrangement.SpaceEvenly) {

        DateText(
            date = date.minusDays(2),
            onDateTextClick = {
                selectedIndex = 0
                onDateChange()
            },
            isSelected = selectedIndex == 0
        )
        DateText(
            date = date.minusDays(1),
            onDateTextClick = { selectedIndex = 1 },
            isSelected = selectedIndex == 1
        )
        DateText(
            date = date.minusDays(0),
            onDateTextClick = { selectedIndex = 2 },
            isSelected = selectedIndex == 2
        )
        DateText(
            date = date.plusDays(1),
            onDateTextClick = { selectedIndex = 3 },
            isSelected = selectedIndex == 3
        )
        DateText(
            date = date.plusDays(2),
            onDateTextClick = { selectedIndex = 4 },
            isSelected = selectedIndex == 4
        )
    }
}

@Preview
@Composable
fun DateTextsRowPreview() {

    InstantScoreTheme() {
        DateTextsRow()
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DateTextsRowPreviewDark() {

    InstantScoreTheme() {
        DateTextsRow()
    }
}