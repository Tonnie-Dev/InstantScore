package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate
import com.uxstate.instantscore.R
import com.uxstate.instantscore.utils.toReverseStringDate
import java.util.Date

@Composable
fun SecondaryDateStrip(date: LocalDate, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    Row(
            modifier = modifier
                    .fillMaxWidth()
                    .padding(spacing.spaceSmall),
            horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TodayDate(onDateTextClick = {})
        SelectedDate(date = date)
        DatePickerItem(onDateChange = {})
    }


}


@Composable
fun TodayDate(onDateTextClick: (date: LocalDate) -> Unit, modifier: Modifier = Modifier) {

    val today = LocalDate.now()
    val spacing = LocalSpacing.current
    Column(
            modifier = modifier
                    .clickable {

                        onDateTextClick(today)
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
                text = "${today.dayOfMonth} ${today.dayOfMonth}",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
        )
    }
}


@Composable
fun SelectedDate(date: LocalDate, modifier: Modifier = Modifier) {

    val spacing = LocalSpacing.current
    Column(
            modifier = modifier
                    .clickable {

                        //onDateTextClick(today)
                    }
                    .padding(spacing.spaceSmall),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
    ) {
        Text(
                text = "${date.dayOfMonth}",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
        )
        Text(
                text = date.toReverseStringDate(),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
        )
    }
}