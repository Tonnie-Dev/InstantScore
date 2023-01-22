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
    onHomeDateTabClick: (date: LocalDate) -> Unit,
    onDateTabClick: (date: LocalDate) -> Unit,
    onCalendarDateChange: (date: LocalDate) -> Unit,
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
                onSecondaryHomeIconClick = onHomeDateTabClick,
                onCalendarDateChange = onCalendarDateChange,
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
                DateTextsRow(onDateChange = onDateTabClick)
                DatePickerItem(onCalendarDateChange = onCalendarDateChange)
            }
        }
    }
}

@Preview
@Composable
fun DateStripPreview() {

    DateStrip(
        date = LocalDate.now(),
        onDateTabClick = {},
        onCalendarDateChange = {},
        isCalendarClicked = false,
        onHomeDateTabClick = {},
        onTogglePrevDate = {},
        onToggleNextDate = {}
    )
}