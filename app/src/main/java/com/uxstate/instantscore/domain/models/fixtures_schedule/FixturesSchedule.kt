package com.uxstate.instantscore.domain.models.fixtures_schedule

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixturesSchedule(
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val league: League,
    val teams: Pair<Team, Team>,
    val goals: Goal,
    val timeStamp:Long,
    val matchDay:Long
) : Parcelable