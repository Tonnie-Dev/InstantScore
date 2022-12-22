package com.uxstate.instantscore.domain.models.league

data class Season(
    val year: Int,
    val startDate: String,
    val endDate: String,
    val isCurrent: Boolean
)
