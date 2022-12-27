package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import java.time.LocalDate

@Composable
fun DateText(
    date: LocalDate,
    onDateTextClick: (localDate: LocalDate) -> Unit,
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    highlightColor: Color = MaterialTheme.colorScheme.primary,
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {

    val spacing = LocalSpacing.current

    val isToday = (date.dayOfMonth == LocalDate.now().dayOfMonth)
    val dayOfWeek = if (isToday) "TODAY" else date.dayOfWeek.name.substring(0..2)
    val month = date.month.name.substring(0..2)
    val dayOfMonth = date.dayOfMonth.toString()

    Column(modifier = modifier
            .clickable { onDateTextClick(date) }
            .padding(spacing.spaceExtraSmall),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
        Text(
                text = dayOfWeek,
                style = MaterialTheme.typography.titleMedium,
                color = if (isSelected) highlightColor else textColor,
                textAlign = TextAlign.Center
        )
        Text(
                text = "$dayOfMonth $month",
                style = MaterialTheme.typography.labelSmall,
                color = if (isSelected) highlightColor else textColor,
                textAlign = TextAlign.Center
        )
    }
}


@Preview
@Composable
fun DateTextPreview() {
    InstantScoreTheme {
        DateText(date = LocalDate.now(), onDateTextClick = {})
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DateTextPreviewDark() {

    InstantScoreTheme {

        DateText(
                date = LocalDate.now()
                        .minusDays(2), onDateTextClick = {})
    }

}