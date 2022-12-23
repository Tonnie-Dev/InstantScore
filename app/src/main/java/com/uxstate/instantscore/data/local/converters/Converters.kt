package com.uxstate.instantscore.data.local.converters

import com.uxstate.instantscore.domain.models.fixtures.Event

class Converters {

    fun writeEventToRoomString(event: Event): String {
        val timeElapsed = event.timeElapsed.toString()
        val player = event.player
        val assist = event.assist
        val eventType = event.eventType


        val eventPropertiesList = listOf(timeElapsed, player, eventType, assist)

        return eventPropertiesList.joinToString(separator = "~")

    }

    fun readEventFromRoom(roomString: String): Event {

        val eventPropertiesList = roomString.split("~")
                .map { it }

        val timeElapsed = eventPropertiesList[0]
        val player = eventPropertiesList[1]
        val assist = eventPropertiesList[2]
        val eventType = eventPropertiesList[3]
        return Event(
                timeElapsed = timeElapsed.toInt(),
                player = player,
                assist = assist,
                eventType = eventType
        )

    }
}