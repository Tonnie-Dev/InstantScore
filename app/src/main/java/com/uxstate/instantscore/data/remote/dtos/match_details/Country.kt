package com.uxstate.instantscore.data.remote.dtos.match_details

import com.squareup.moshi.Json

data class Country(
    @Json(name = "continent")
    val continent: String,
    @Json(name = "country_code")
    val countryCode: String,
    @Json(name = "country_id")
    val countryId: Int,
    @Json(name = "name")
    val name: String
)