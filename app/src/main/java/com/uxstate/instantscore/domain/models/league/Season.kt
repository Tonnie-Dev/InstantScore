package com.uxstate.instantscore.domain.models.league

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Season(
    val year: Int,
    val startDate: String,
    val endDate: String,
    val isCurrent: Boolean
) : Parcelable
