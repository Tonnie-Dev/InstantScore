package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class FullTime(
    val fullTimeAwayScore: Int,
    val fullTimeHomeScore: Int,

) : Parcelable