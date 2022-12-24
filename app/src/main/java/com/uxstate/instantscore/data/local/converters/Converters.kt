package com.uxstate.instantscore.data.local.converters

import androidx.room.TypeConverter
import com.uxstate.instantscore.domain.models.fixtures.Event
import com.uxstate.instantscore.domain.models.fixtures.Stats

class Converters {

    @TypeConverter
    fun writeEventToRoom(event: Event): String {
        val timeElapsed = event.timeElapsed.toString()
        val player = event.player
        val assist = event.assist
        val eventType = event.eventType


        val eventPropertiesList = listOf(timeElapsed, player, eventType, assist)

        return eventPropertiesList.joinToString(separator = "~")

    }

    @TypeConverter
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

    @TypeConverter
    fun writeStatsToRoom(stats: Stats): String {

        val possession = stats.possession
        val shotsOnGoal = stats.shotsOnGoal
        val shotsOffGoal = stats.shotsOffGoal
        val totalShots = stats.totalShots
        val cornerKicks = stats.cornerKicks
        val offSides = stats.offSides
        val fouls = stats.fouls
        val yellowCards = stats.yellowCards
        val redCards = stats.redCards

        val statsPropertiesList = listOf(
                possession,
                shotsOnGoal,
                shotsOffGoal,
                totalShots,
                cornerKicks,
                offSides,
                fouls,
                yellowCards,
                redCards
        )

      return  statsPropertiesList.joinToString("~")
    }


}