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

        val possession = stats.possession.toString()
        val shotsOnGoal = stats.shotsOnGoal.toString()
        val shotsOffGoal = stats.shotsOffGoal.toString()
        val totalShots = stats.totalShots.toString()
        val cornerKicks = stats.cornerKicks.toString()
        val offSides = stats.offSides.toString()
        val fouls = stats.fouls.toString()
        val yellowCards = stats.yellowCards.toString()
        val redCards = stats.redCards.toString()

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

        return statsPropertiesList.joinToString("~")
    }

    @TypeConverter
    fun readStatsFromRoom(roomString: String): Stats {
        val statsPropertiesList = roomString.split("~")
                .map { it }

        val possession = statsPropertiesList[0].toInt()
        val shotsOnGoal = statsPropertiesList[1].toInt()
        val shotsOffGoal = statsPropertiesList[2].toInt()
        val totalShots = statsPropertiesList[3].toInt()
        val cornerKicks = statsPropertiesList[4].toInt()
        val offSides = statsPropertiesList[5].toInt()
        val fouls = statsPropertiesList[6].toInt()
        val yellowCards = statsPropertiesList[7].toInt()
        val redCards = statsPropertiesList[8].toInt()

        return Stats(
                possession = possession,
                shotsOnGoal = shotsOnGoal,
                shotsOffGoal = shotsOffGoal,
                totalShots = totalShots,
                cornerKicks = cornerKicks,
                offSides = offSides,
                fouls = fouls,
                yellowCards = yellowCards,
                redCards = redCards
        )

    }


}