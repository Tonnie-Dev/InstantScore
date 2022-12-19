package com.uxstate.instantscore.data.remote.dtos.match_details

import com.squareup.moshi.Json

data class Stats(
    @Json(name = "et_score")
    val etScore: Any?,
    @Json(name = "ft_score")
    val ftScore: String,
    @Json(name = "ht_score")
    val htScore: String,
    @Json(name = "ps_score")
    val psScore: Any?
)