package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Standing(
    @Json(name = "away")
    val away: Away,
    @Json(name = "home")
    val home: Home,
    @Json(name = "overall")
    val overall: Overall,
    @Json(name = "points")
    val points: Int,
    @Json(name = "position")
    val position: Int,
    @Json(name = "result")
    val result: String?,
    @Json(name = "status")
    val status: String,
    @Json(name = "team_id")
    val teamId: Int
)