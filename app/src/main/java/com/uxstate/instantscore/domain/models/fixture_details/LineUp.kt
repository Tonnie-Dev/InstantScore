package com.uxstate.instantscore.domain.models.fixture_details


import android.os.Parcelable
import com.uxstate.instantscore.data.remote.dtos.fixture_details.StartXI
import com.uxstate.instantscore.data.remote.dtos.fixture_details.Substitute
import kotlinx.parcelize.Parcelize

@Parcelize
data class LineUp(
val coach: Coach,
val startingXI: List<Player>,
val substitutes: List<Player>,
val team: Team
):Parcelable
