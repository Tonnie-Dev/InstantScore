package com.uxstate.instantscore.presentation.screens.home_screen.components.fixture_card

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League

@Composable
fun LeagueFixturesCard(league: League, fixtures: List<Fixture>, onClickFixtureCard: (Int) -> Unit) {

    Column() {
        LeagueHeader(league = league)

        fixtures.forEach { fixture ->

            FixtureCard(fixture = fixture, onClickFixtureCard = onClickFixtureCard)
        }
    }
}