package com.uxstate.instantscore.domain.models.fixtures_details

import android.os.Parcelable
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team
import kotlinx.parcelize.Parcelize

@Parcelize
data class FixtureBonoko(
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val teams: Pair<Team, Team>
) : Parcelable
