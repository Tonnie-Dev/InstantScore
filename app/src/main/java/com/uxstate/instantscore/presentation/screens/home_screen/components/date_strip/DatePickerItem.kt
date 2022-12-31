package com.uxstate.instantscore.presentation.screens.home_screen.components.date_strip

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.R
import com.uxstate.instantscore.presentation.ui.theme.InstantScoreTheme
import com.uxstate.instantscore.utils.LocalSpacing
import com.uxstate.instantscore.utils.toStringDate
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.LocalDate

@Composable
fun DatePickerItem(onDateChange: (date: LocalDate) -> Unit) {

    val spacing = LocalSpacing.current
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    val formattedDate by remember {
        derivedStateOf {

            // uses date util functions extension function
            pickedDate.toStringDate()
        }
    }
    val dialogState = rememberMaterialDialogState()

    Icon(
        painter = painterResource(id = R.drawable.calender_icon),
        contentDescription = stringResource(
            R.string.calendar_text
        ),
        modifier = Modifier.clickable { dialogState.show() }
            .size(spacing.spaceLarge + spacing.spaceSmall)
    )

    MaterialDialog(
        dialogState = dialogState,
        buttons = {
            positiveButton("OK") { onDateChange(pickedDate) }
            negativeButton("Cancel") {}
        }
    ) {

        this.datepicker(
            initialDate = LocalDate.now(),
            title = stringResource(R.string.match_date_label)
        ) {
            // we get the selected date here
            pickedDate = it
        }
    }
}

@Preview
@Composable
fun DatePickerItemPreview() {

    InstantScoreTheme {

        DatePickerItem(onDateChange = {})
    }
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DatePickerItemPreviewDark() {

    InstantScoreTheme {

        DatePickerItem(onDateChange = {})
    }
}