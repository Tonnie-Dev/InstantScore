package com.uxstate.instantscore.data.remote.dtos.top_scorers

import com.squareup.moshi.Json

data class Goals(
    @Json(name = "away")
    val away: Int,
    @Json(name = "home")
    val home: Int,
    @Json(name = "overall")
    val overall: Int
)