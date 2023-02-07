package com.uxstate.instantscore.presentation.screens.live_screen.components

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
import com.uxstate.instantscore.R
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.presentation.screens.common_components.LottieDefinition
import com.uxstate.instantscore.presentation.screens.destinations.DetailsScreenDestination
import com.uxstate.instantscore.presentation.screens.destinations.StandingsScreenDestination
import com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card.LeagueFixturesCard
import com.uxstate.instantscore.presentation.screens.standings_screen.LeagueNavArgumentsHolder

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LiveFixturesList(
    mappedFixtures: List<Pair<League, List<Fixture>>>,
    navigator: DestinationsNavigator,
    pullRefreshState: PullRefreshState,
    isLoading: Boolean,
    isRefreshing: Boolean
) {

    Box(
        modifier = Modifier
            .pullRefresh(state = pullRefreshState)
            .zIndex(-1f)
            .fillMaxSize(),
        contentAlignment = Alignment.Center

    ) {

        if (isLoading)
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        else if (mappedFixtures.isEmpty()) {

            LottieDefinition(lottieRes = R.raw.empty_info)
        } else {
            // content to be refreshed
            LazyColumn(modifier = Modifier.fillMaxSize()) {

                items(mappedFixtures) {

                    val league = it.first
                    LeagueFixturesCard(
                        league = it.first,
                        fixtures = it.second,
                        onClickFixtureCard = { fixtureId ->
                            navigator.navigate(DetailsScreenDestination(fixtureId))
                        }, onClickLeagueHeader = {
                        navigator.navigate(
                            direction = StandingsScreenDestination(
                                navArgs = LeagueNavArgumentsHolder(
                                    id = league.id,
                                    name = league.name,
                                    country = league.country,
                                    leagueLogo = league.leagueLogo,
                                    countryFlag = league.countryFlag,
                                    season = league.season
                                )
                            )
                        )
                    }
                    )
                }
            }

            PullRefreshIndicator(
                // controls the infinite spinning
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}