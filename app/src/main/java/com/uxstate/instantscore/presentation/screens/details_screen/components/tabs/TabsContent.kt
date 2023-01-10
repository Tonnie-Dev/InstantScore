package com.uxstate.instantscore.presentation.screens.details_screen.components.tabs

import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabItemSealedClass>, pagerState: PagerState) {

    HorizontalPager(count = tabs.size, state = pagerState) {
        page: Int ->

        tabs[page].composeFunction
    }
}