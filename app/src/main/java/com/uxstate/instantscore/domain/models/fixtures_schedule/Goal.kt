package com.uxstate.instantscore.domain.models.fixtures_schedule

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Goal(
    val homeTeamScore: Int,
    val awayTeamScore: Int
) : Parcelable
