package com.uxstate.instantscore.presentation.screens.details_screen.tabs

import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.uxstate.instantscore.utils.LocalSpacing
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsRow(tabs: List<TabItemSealedClass>, pagerState: PagerState) {

    val spacing = LocalSpacing.current

    val coroutineScope = rememberCoroutineScope()

    // TabRow from Material3
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onSurface,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.pagerTabIndicatorOffset(
                    pagerState = pagerState,
                    tabPositions = tabPositions
                )
            )
        },
        divider = {
            TabRowDefaults.Divider(
                thickness = spacing.spaceDoubleDp,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    ) {
        tabs.forEachIndexed {

            i, tabItem ->

            // Use LeadingIconTab in case you need to suffix the header with an icon
            Tab(
                selected = pagerState.currentPage == i,
                onClick = { coroutineScope.launch { pagerState.animateScrollToPage(i) } },
                text = {

                    Text(
                        text = tabItem.tabTitle,
                        color = if (pagerState.currentPage == i)
                            MaterialTheme.colorScheme.onSurface
                        else
                            MaterialTheme.colorScheme.onSurface.copy(
                                alpha = ContentAlpha.disabled
                            )
                    )
                }
            )
        }
    }
}