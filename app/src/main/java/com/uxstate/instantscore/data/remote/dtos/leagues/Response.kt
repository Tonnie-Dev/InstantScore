package com.uxstate.instantscore.data.remote.dtos.leagues

import com.squareup.moshi.Json

data class Response(
    @Json(name = "country")
    val country: Country,
    @Json(name = "league")
    val league: League,
    @Json(name = "seasons")
    val seasons: List<Season>
)