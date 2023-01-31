package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Response(
    @Json(name = "league")
    val league: League
)