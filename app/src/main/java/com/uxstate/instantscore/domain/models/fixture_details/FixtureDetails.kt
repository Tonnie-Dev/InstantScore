package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import com.uxstate.instantscore.data.remote.dtos.fixture_details.Score
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixtureDetails(
    val fixtureId: Int,
    val timeStamp: Long,
    val referee:String,
    val venue: String,
    val status: String,
    val timeElapsed: Int,
    val homeScore:Int,
    val awayScore:Int,
    val leagueName:String,
    val teams: Pair<Team, Team>,
    val events: List<Event>,
    val stats: Stats,
    val lineUps:List<LineUp>,
    val score: Score,

    ) : Parcelable
