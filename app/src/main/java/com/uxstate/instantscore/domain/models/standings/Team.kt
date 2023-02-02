package com.uxstate.instantscore.domain.models.standings

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    val id: Int,
    val name: String,
    val logo: String
) : Parcelable
