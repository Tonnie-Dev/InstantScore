package com.uxstate.instantscore.presentation.screens.details_screen.state

import com.uxstate.instantscore.domain.models.fixture_details.*

data class FixtureDetailsState(
    val fixtureId: Int = -1,
    val timeStamp: Long = 0L,
    val referee: String = "",
    val venue: String = "",
    val status: String = "",
    val timeElapsed: Int = -1,
    val homeGoals: Int = -1,
    val awayGoals: Int = -1,
    val leagueName: String = "",
    val teams: Pair<Team, Team> = Pair(
            first = Team(
                    name = "",
                    logo = "",
                    isWinner = false
            ), second = Team(
            name = "",
            logo = "",
            isWinner = false
    )
    ),
    val events: List<Event> = listOf(),
    val stats: List<Stats> = listOf(),
    val lineUps: List<LineUp> = listOf(),
    val score: Score = Score(
            extraTimeScore = ExtraTime(
                    extraTimeAwayScore = 0,
                    extraTimeHomeScore = 0
            ),
            fullTimeScore = FullTime(fullTimeAwayScore = 0, fullTimeHomeScore = 0),
            penaltyShootOutScore = PenaltyShootOut(
                    penaltiesScoredAway = 0,
                    penaltiesScoredHome = 0
            )
    )
)