package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Home(
    @Json(name = "draw")
    val draw: Int,
    @Json(name = "goals")
    val goals: Goals,
    @Json(name = "lose")
    val lose: Int,
    @Json(name = "played")
    val played: Int,
    @Json(name = "win")
    val win: Int
)