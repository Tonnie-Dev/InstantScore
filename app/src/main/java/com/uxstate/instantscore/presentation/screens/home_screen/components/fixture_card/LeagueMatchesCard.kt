package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League

@Composable
fun LeagueMatchesCard(league: League, fixtures: List<Fixture>) {

    LazyColumn(content = {

        item {

            LeagueHeader(league = league)
        }

        items(fixtures) { fixture ->

            MatchCard(fixture = fixture)
        }
    })
}