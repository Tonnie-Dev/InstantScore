package com.uxstate.instantscore.domain.models.standings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class League(
    val id: Int,
    val name: String,
    val country: String,
    val leagueLogo: String,
    val countryFlag: String,
    val season:Int
) : Parcelable
