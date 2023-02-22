package com.uxstate.instantscore.presentation.screens.stats_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.instantscore.presentation.screens.stats_screen.components.PlayerStatsList
import com.uxstate.instantscore.presentation.screens.stats_screen.components.StatsChipRow

@Destination
@Composable
fun StatisticsScreen() {

    Column(Modifier.fillMaxSize()) {
        StatsChipRow(onClickChip = { /*TODO*/ })

        PlayerStatsList(stats = emptyList())
    }
}