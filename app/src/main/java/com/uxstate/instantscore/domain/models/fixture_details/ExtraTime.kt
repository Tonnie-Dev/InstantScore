package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ExtraTime (val extraTimeAwayScore: Int,
val extraTimeHomeScore: Int,

) : Parcelable
