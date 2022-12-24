package com.uxstate.instantscore.data.local.converters

import androidx.room.TypeConverter
import com.uxstate.instantscore.domain.models.fixtures.Event
import com.uxstate.instantscore.domain.models.fixtures.Stats
import com.uxstate.instantscore.domain.models.fixtures.Status
import com.uxstate.instantscore.domain.models.fixtures.Team

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


    @TypeConverter
    fun writeStatusToRoom(status: Status): String {

        val fixtureLong = status.fixtureLong
        val fixtureShort = status.fixtureShort
        val timeElapsed = status.timeElapsed.toString()
        val statusPropertiesList = listOf(fixtureLong, fixtureShort, timeElapsed)

        return statusPropertiesList.joinToString("~")
    }

    @TypeConverter
    fun readStatusFromRoom (roomString:String):Status {

        val statusPropertiesList = roomString.split("~").map { it }
        val fixtureLong = statusPropertiesList[0]
        val fixtureShort = statusPropertiesList[1]
        val timeElapsed = statusPropertiesList[2].toInt()

        return Status(fixtureLong = fixtureLong, fixtureShort = fixtureShort, timeElapsed = timeElapsed)
    }

    @TypeConverter
    fun writeTeamToRoom(team:Team):String{

        val name = team.name
        val logo = team.logo
        val goalScored = team.goalScored.toString()

        val teamPropertiesList = listOf(name, logo, goalScored )

        return teamPropertiesList.joinToString("~")
    }

@TypeConverter
fun readTeamFromRoom(roomString: String): Team {

    val teamPropertiesString = roomString.split("~").map { it }

    val name = teamPropertiesString[0]
    val logo = teamPropertiesString[1]
    val goalScored = teamPropertiesString[2].toInt()

    return Team(name = name, logo = logo, goalScored = goalScored)
}


}