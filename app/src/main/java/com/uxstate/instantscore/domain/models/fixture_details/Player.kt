package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Player(

    val playerId: Int,
    val playerName: String,
    val playerNumber: Int,
    val playerPosition: String
) : Parcelable
