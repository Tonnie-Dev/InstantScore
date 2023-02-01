package com.uxstate.instantscore.domain.models.standings

import com.squareup.moshi.Json
import com.uxstate.instantscore.data.remote.dtos.standings.All
import com.uxstate.instantscore.data.remote.dtos.standings.Away
import com.uxstate.instantscore.data.remote.dtos.standings.Home
import com.uxstate.instantscore.data.remote.dtos.standings.Team

data class Standing(

    val description: String,
    val goalsAgainst: Int,
    val goalsFor: Int,
    val goalsDiff: Int,
    val group: String,
    val points: Int,
    val rank: Int,
    val team: Team,
    val league: League

)
