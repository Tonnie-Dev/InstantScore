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
    onDateChange: (date: LocalDate) -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    Card(
        modifier = modifier,
        shape = RectangleShape
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            LiveButton(onClickLiveButton = {})
            DateTextsRow(onDateChange = onDateChange)
            DatePickerItem(onDateChange = onDateChange)
        }
    }
}



@Preview
@Composable
fun DateStripPreview() {

    DateStrip(onDateChange = {})
}