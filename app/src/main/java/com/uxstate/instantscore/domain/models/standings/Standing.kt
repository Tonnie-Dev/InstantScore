package com.uxstate.instantscore.domain.models.standings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Standing(

    val description: String,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val goalsDiff: Int,
    val group: String,
    val points: Int,
    val rank: Int,
    val team: Team,
    val league: League

) : Parcelable
