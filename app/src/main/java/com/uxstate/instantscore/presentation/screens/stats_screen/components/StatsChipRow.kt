package com.uxstate.instantscore.presentation.screens.stats_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.uxstate.instantscore.utils.LocalSpacing

@Composable
fun StatsChipRow(
    onClickChip: (statType: String) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedChipIndex by remember { mutableStateOf(0) }
    val spacing = LocalSpacing.current
    Card(
        shape = RectangleShape,
        modifier = modifier.padding(bottom = spacing.spaceSmall)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(spacing.spaceSmall),
            modifier = Modifier.fillMaxWidth()
                .padding(
                    spacing.spaceSmall
                )

        ) {
            for (i in 0..3) {

                val isSelected = (selectedChipIndex == i)
                val endpoint = when (i) {
                    0 -> "topscorers"
                    1 -> "topassists"
                    2 -> "topyellowcards"
                    3 -> "topredcards"

                    else -> "topscorers"
                }

                StatsChip(
                    chipIndex = i,
                    isSelected = isSelected,
                    onClickChip = {
                        selectedChipIndex = i
                        onClickChip(endpoint)
                    }
                )
            }
        }
    }
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
        shape = RoundedCornerShape(spacing.spaceSmall),
        modifier = modifier
    )
}

@Preview
@Composable
fun StatsChipRowPreview() {
    StatsChipRow(onClickChip = {})
}

@Preview
@Composable
fun StatsChipRowPreviewDark() {
    StatsChipRow(onClickChip = {})
}

@Preview
@Composable
fun StatsChipPreview() {

    StatsChip(1, true, onClickChip = {})
}

@Preview
@Composable
fun StatsChipPreviewDark() {

    StatsChip(1, true, onClickChip = {})
}