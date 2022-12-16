package com.uxstate.instantscore.data.remote.dtos.matches


import com.squareup.moshi.Json

data class StatsX(
    @Json(name = "away_score")
    val awayScore: Int,
    @Json(name = "et_score")
    val etScore: Any?,
    @Json(name = "ft_score")
    val ftScore: Any?,
    @Json(name = "home_score")
    val homeScore: Int,
    @Json(name = "ht_score")
    val htScore: Any?,
    @Json(name = "ps_score")
    val psScore: Any?
)