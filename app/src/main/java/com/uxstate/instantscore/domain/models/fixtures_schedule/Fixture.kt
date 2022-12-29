package com.uxstate.instantscore.domain.models.fixtures_schedule

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.time.LocalDate

@Parcelize
data class Fixture(
    val fixtureId: Int,
    val date: LocalDate,
    val status: Status,
    val league: League,
    val teams: Pair<Team, Team>,
    val goals: Goal,

) : Parcelable