package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LineUp(
    val coach: Coach,
    val startingXI: List<Player>,
    val substitutes: List<Player>,
    val team: Team
) : Parcelable
