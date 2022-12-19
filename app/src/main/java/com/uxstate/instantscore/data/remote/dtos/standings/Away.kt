package com.uxstate.instantscore.data.remote.dtos.standings

import com.squareup.moshi.Json

data class Away(
    @Json(name = "draw")
    val draw: Int,
    @Json(name = "games_played")
    val gamesPlayed: Int,
    @Json(name = "goals_against")
    val goalsAgainst: Int,
    @Json(name = "goals_diff")
    val goalsDiff: Int,
    @Json(name = "goals_scored")
    val goalsScored: Int,
    @Json(name = "lost")
    val lost: Int,
    @Json(name = "won")
    val won: Int
)