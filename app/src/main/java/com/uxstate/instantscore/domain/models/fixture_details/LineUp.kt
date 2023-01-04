package com.uxstate.instantscore.domain.models.fixture_details

import com.squareup.moshi.Json
import com.uxstate.instantscore.data.remote.dtos.fixture_details.Coach
import com.uxstate.instantscore.data.remote.dtos.fixture_details.StartXI
import com.uxstate.instantscore.data.remote.dtos.fixture_details.Substitute


data class LineUp(
val coach: Coach,
val startXI: List<StartXI>,
val substitutes: List<Substitute>,
val team: Team
)
