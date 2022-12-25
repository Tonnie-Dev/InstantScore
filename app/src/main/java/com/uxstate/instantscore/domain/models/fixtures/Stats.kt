package com.uxstate.instantscore.domain.models.fixtures

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
    val possession: Int,
    val shotsOnGoal: Int,
    val shotsOffGoal: Int,
    val totalShots: Int,
    val cornerKicks: Int,
    val offSides: Int,
    val fouls: Int,
    val yellowCards: Int,
    val redCards: Int
): Parcelable
