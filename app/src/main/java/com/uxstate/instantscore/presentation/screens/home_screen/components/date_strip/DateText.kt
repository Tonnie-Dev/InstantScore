package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import java.time.LocalDate

@Composable
fun DateText(dayText:String, dateText:String, onClickListener:(localDate:LocalDate)-> Unit) {


    Column {
        Text(text = dateText, style = MaterialTheme.typography.la)
    }

}