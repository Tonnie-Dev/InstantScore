package com.uxstate.instantscore.data.remote.dtos.fixture_details

import com.squareup.moshi.Json

data class Score(
    @Json(name = "extratime")
    val extratime: Extratime,
    @Json(name = "fulltime")
    val fulltime: Fulltime,
    @Json(name = "halftime")
    val halftime: Halftime,
    @Json(name = "penalty")
    val penalty: PenaltyX
)