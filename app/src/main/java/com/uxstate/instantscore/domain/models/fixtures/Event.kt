package com.uxstate.instantscore.domain.models.fixtures

data class Event(
    val pointInTime: Int,
    val player: String,
    val assist: String,
    val eventType: String
)