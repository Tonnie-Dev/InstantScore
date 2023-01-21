package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.toRegularStringDate
import java.time.LocalDate

@Composable
fun SecondaryDateStrip(
    selectedDate: LocalDate,
    onSecondaryHomeIconClick: (date: LocalDate) -> Unit,
    onTogglePrevDate: (date: LocalDate) -> Unit,
    onToggleNextDate: (date: LocalDate) -> Unit,
    onCalendarDateChange: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier,

) {

    val spacing = LocalSpacing.current
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(spacing.spaceExtraSmall),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        SecondaryHomeIcon(onSecondaryHomeIconClick = onSecondaryHomeIconClick)
        TogglePreviousDate(onTogglePrevDate = onTogglePrevDate, selectedDate = selectedDate)
        SelectedDate(date = selectedDate)
        ToggleNextDate(onToggleNextDate = onToggleNextDate, selectedDate = selectedDate)

        DatePickerItem(onCalendarDateChange = onCalendarDateChange)
        /* Box(
             modifier = modifier
                 .fillMaxWidth()
                 .padding(spacing.spaceDefault)
         ) {


         }*/
    }
}

@Composable
fun SecondaryHomeIcon(
    onSecondaryHomeIconClick: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {

    val today = LocalDate.now()
    val spacing = LocalSpacing.current

    Icon(
        imageVector = Icons.Default.Home,
        contentDescription = stringResource(R.string.home_label),
        modifier = modifier
            .size(spacing.spaceLarge + spacing.spaceSmall)
            .clickable {
                onSecondaryHomeIconClick(today)
            }
    )
    /* Column(
         modifier = modifier
             .clickable {

                 onTodaySecTextClick(today)
             }
             .padding(spacing.spaceSmall),
         horizontalAlignment = Alignment.CenterHorizontally,
         verticalArrangement = Arrangement.Center
     ) {
         Text(
             text = stringResource(R.string.today_label_upper),
             style = MaterialTheme.typography.titleMedium,
             color = MaterialTheme.colorScheme.onSurface,
             textAlign = TextAlign.Center
         )
         Text(
             text = "${today.dayOfMonth}-${today.month.name.substring(0..2)}",
             style = MaterialTheme.typography.labelSmall,
             color = MaterialTheme.colorScheme.onSurface,
             textAlign = TextAlign.Center
         )
     }*/
}

@Composable
fun SelectedDate(date: LocalDate, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    Column(
        modifier = modifier
            .clickable {

                // onDateTextClick(today)
            }
            .padding(spacing.spaceSmall),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = date.dayOfWeek.name,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
        Text(
            text = date.toRegularStringDate(),
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun TogglePreviousDate(
    selectedDate: LocalDate,
    onTogglePrevDate: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Icon(
        painter = painterResource(id = R.drawable.arrow_left),
        contentDescription = stringResource(R.string.before_text),
        modifier = modifier
            .size(spacing.spaceLarge + spacing.spaceMedium)
            .clickable { onTogglePrevDate(selectedDate.minusDays(1)) },
        tint = MaterialTheme.colorScheme.primary
    )
}

@Composable
fun ToggleNextDate(
    selectedDate: LocalDate,
    onToggleNextDate: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Icon(
        painter = painterResource(id = R.drawable.arrow_right),
        contentDescription = stringResource(R.string.before_text),
        modifier = modifier
            .size(spacing.spaceLarge + spacing.spaceMedium)
            .clickable { onToggleNextDate(selectedDate.plusDays(1)) },
        tint = MaterialTheme.colorScheme.primary
    )
}

@Preview
@Composable
fun ToggleBeforePrev() {

    InstantScoreTheme {
        TogglePreviousDate(onTogglePrevDate = {}, selectedDate = LocalDate.now())
    }
}

@Preview
@Composable
fun ToggleNextPrev() {

    InstantScoreTheme {
        ToggleNextDate(onToggleNextDate = {}, selectedDate = LocalDate.now())
    }
}

@Preview
@Composable
fun SecondaryDateStripPreview() {

    InstantScoreTheme {
        SecondaryDateStrip(
            selectedDate = LocalDate.now(),
            onSecondaryHomeIconClick = {},
            onCalendarDateChange = {},
            onToggleNextDate = {},
            onTogglePrevDate = {}
        )
    }
}