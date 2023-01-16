package com.uxstate.instantscore.presentation.screens.details_screen.state

import com.uxstate.instantscore.domain.models.fixture_details.*

data class FixtureDetailsState(
    val isLoading: Boolean = false,
    val errorMessage: String = "",
    val fixtureDetails: FixtureDetails = FixtureDetails(
        fixtureId = -1,
        timeStamp = 0L,
        referee = "",
        venue = "",
        status = "",
        timeElapsed = -1,
        homeGoals = -1,
        awayGoals = -1,
        leagueName = "",
        teams = Pair(
            first = Team(
                name = "",
                logo = "",
                isWinner = false
            ),
            second = Team(
                name = "",
                logo = "",
                isWinner = false
            )
        ),
        events = listOf(),
        lineUps = listOf(),
        score = Score(
            extraTimeScore = ExtraTime(
                extraTimeAwayScore = 0,
                extraTimeHomeScore = 0
            ),
            fullTimeScore = FullTime(fullTimeAwayScore = 0, fullTimeHomeScore = 0),
            penaltyShootOutScore = PenaltyShootOut(
                penaltiesScoredAway = 0,
                penaltiesScoredHome = 0
            )
        ),
        stats = listOf()
    )
)
