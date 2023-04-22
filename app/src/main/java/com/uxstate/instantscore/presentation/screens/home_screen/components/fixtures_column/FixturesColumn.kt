package com.uxstate.instantscore.presentation.screens.home_screen.components.fixtures_column

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.PullRefreshState
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.zIndex
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FixturesColumn(
    mappedFixtures: List<Pair<League, List<Fixture>>>,
    navigator: DestinationsNavigator,
    swipeRefreshState: PullRefreshState,
    isLoading: Boolean,
    isRefreshing: Boolean
) {

    Box(
        modifier = Modifier
            .pullRefresh(state = swipeRefreshState)
            .zIndex(-1f)

    ) {

        if (isLoading)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        else {
            // content to be refreshed
            LazyColumn(modifier = Modifier.fillMaxSize()) {

                items(mappedFixtures) {

                    /*LeagueFixturesCard(
                        league = it.first,
                        fixtures = it.second,
                        onClickFixtureCard = { fixtureId ->
                            navigator.navigate(DetailsScreenDestination(fixtureId))
                        }, onClickLeagueHeader = {}
                    )*/
                }
            }

            PullRefreshIndicator(
                // controls the infinite spinning
                refreshing = isRefreshing,
                state = swipeRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}