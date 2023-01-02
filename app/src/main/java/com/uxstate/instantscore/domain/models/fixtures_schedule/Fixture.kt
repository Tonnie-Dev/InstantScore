package com.uxstate.instantscore.domain.models.fixtures_schedule

import android.os.Parcelable
import java.time.LocalDate
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fixture(
    val fixtureId: Int,
    val date: LocalDate,
    val startTime: Long,
    val status: Status,
    val league: League,
    val teams: Pair<Team, Team>,
    val goals: Goal,

) : Parcelable