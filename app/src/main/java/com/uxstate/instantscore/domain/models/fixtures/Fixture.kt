package com.uxstate.instantscore.domain.models.fixtures

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fixture(
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val teams: Pair<Team, Team>
):Parcelable
