package com.uxstate.instantscore.presentation.screens.details_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.ramcosta.composedestinations.annotation.Destination
import com.uxstate.instantscore.presentation.screens.details_screen.components.FixturePoster
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabItemSealedClass
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabsContent
import com.uxstate.instantscore.presentation.screens.details_screen.components.tabs.TabsRow

@OptIn(ExperimentalPagerApi::class, ExperimentalMaterial3Api::class)
@Destination
@Composable
fun DetailsScreen(fixtureId: Int, viewModel: DetailsViewModel = hiltViewModel()) {

    val state by viewModel.fakeState.collectAsState()
    val pageState = rememberPagerState()

    val tabs = listOf(
        TabItemSealedClass.EventsTab,
        TabItemSealedClass.LineUpsTab,
        TabItemSealedClass.StatsTab
    )

    Scaffold() { paddingValues ->

        Column(modifier = Modifier.padding(paddingValues)) {

            FixturePoster(details = state.fixtureDetails)
            TabsRow(tabs = tabs, pagerState = pageState)
            TabsContent(tabs = tabs, pagerState = pageState)
        }
    }
}