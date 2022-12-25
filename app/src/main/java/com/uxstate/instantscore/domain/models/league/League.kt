package com.uxstate.instantscore.domain.models.league

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val leagueId: Int,
    val logo: String,
    val country: String,
    val seasons: List<Season>
) : Parcelable
