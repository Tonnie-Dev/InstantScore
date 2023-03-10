package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixtureDetails(
    val fixtureId: Int,
    val timeStamp: Long,
    val referee: String,
    val venue: String,
    val status: String,
    val timeElapsed: Int,
    val homeGoals: Int,
    val awayGoals: Int,
    val leagueName: String,
    val teams: Pair<Team, Team>,
    val events: List<Event>,
    val lineUps: List<LineUp>,
    val stats: List<Stats>,
    val score: Score,

) : Parcelable
