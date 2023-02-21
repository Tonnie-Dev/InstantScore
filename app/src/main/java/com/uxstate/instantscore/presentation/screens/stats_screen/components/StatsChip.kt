package com.uxstate.instantscore.presentation.screens.stats_screen.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.utils.LocalSpacing




@Composable
fun StatsChipRow() {
    val isSelected by remember { mutableStateOf(false) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatsChip(
    chipIndex: Int,
    isSelected: Boolean,
    onClickChip: () -> Unit,
    modifier: Modifier = Modifier
) {

    val spacing = LocalSpacing.current
    val chipText = remember {
        when (chipIndex) {
            0 -> "Goals"
            1 -> "Assists"
            2 -> "Yellow Cards"
            3 -> "Red Cards"
            else -> "Goals"
        }
    }
    AssistChip(
            onClick = onClickChip,
            label = { Text(text = chipText) },
            enabled = isSelected,
            shape = RoundedCornerShape(spacing.spaceSmall)
    )


}

@Preview
@Composable
fun StatsChipPreview() {

    StatsChip(1, true, onClickChip = {})
}