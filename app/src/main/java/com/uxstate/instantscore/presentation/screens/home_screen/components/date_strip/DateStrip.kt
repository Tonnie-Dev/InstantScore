package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun DateStrip(
    date: LocalDate,
    onTodayClick: (date: LocalDate) -> Unit,
    onDateChange: (date: LocalDate) -> Unit,
    onTogglePrevDate: (date: LocalDate) -> Unit,
    onToggleNextDate: (date: LocalDate) -> Unit,
    isCalendarClicked: Boolean,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current

    Card(
        modifier = modifier,
        shape = RectangleShape
    ) {

        if (isCalendarClicked) {

            SecondaryDateStrip(
                selectedDate = date,
                onSecondaryHomeIconClick = onTodayClick,
                onCalendarDateChange = onDateChange,
                onTogglePrevDate = onTogglePrevDate,
                onToggleNextDate = onToggleNextDate
            )
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                LiveButton(onClickLiveButton = {})
                DateTextsRow(onDateChange = onDateChange)
                DatePickerItem(onCalendarDateChange = onDateChange)
            }
        }
    }
}

@Preview
@Composable
fun DateStripPreview() {

    DateStrip(
        date = LocalDate.now(),
        onDateChange = {},
        isCalendarClicked = false,
        onTodayClick = {},
        onTogglePrevDate = {},
        onToggleNextDate = {}
    )
}