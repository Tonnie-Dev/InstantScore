package com.uxstate.instantscore.data.remote.dtos.odds


import com.squareup.moshi.Json

data class Data(
    @Json(name = "country_id")
    val countryId: Int,
    @Json(name = "end_date")
    val endDate: String,
    @Json(name = "is_current")
    val isCurrent: Int,
    @Json(name = "league_id")
    val leagueId: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "season_id")
    val seasonId: Int,
    @Json(name = "start_date")
    val startDate: String
)