package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(
    val side:String,
    val possession: Int,
    val shotsOnGoal: Int,
    val shotsOffGoal: Int,
    val totalShots: Int,
    val cornerKicks: Int,
    val offSides: Int,
    val fouls: Int,
    val yellowCards: Int,
    val redCards: Int
) : Parcelable
