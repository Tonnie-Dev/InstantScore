package com.uxstate.instantscore.data.local.converters

import androidx.room.TypeConverter
import com.uxstate.instantscore.domain.models.fixtures_details.Event
import com.uxstate.instantscore.domain.models.fixtures_details.Stats
import com.uxstate.instantscore.domain.models.fixtures_schedule.Goal
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team

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
    fun readStatusFromRoom(roomString: String): Status {

        val statusPropertiesList = roomString.split("~")
            .map { it }
        val fixtureLong = statusPropertiesList[0]
        val fixtureShort = statusPropertiesList[1]
        val timeElapsed = statusPropertiesList[2].toInt()

        return Status(
            fixtureLong = fixtureLong, fixtureShort = fixtureShort, timeElapsed = timeElapsed
        )
    }

    @TypeConverter
    fun writeTeamToRoom(team: Team): String {

        val name = team.name
        val logo = team.logo

        val teamPropertiesList = listOf(name, logo)

        return teamPropertiesList.joinToString("~")
    }

    @TypeConverter
    fun readTeamFromRoom(roomString: String): Team {

        val teamPropertiesString = roomString.split("~")
            .map { it }

        val name = teamPropertiesString[0]
        val logo = teamPropertiesString[1]

        return Team(name = name, logo = logo)
    }

    @TypeConverter
    fun writeTeamPairToRoom(teams: Pair<Team, Team>): String {

        val name1 = teams.first.name
        val logo1 = teams.first.logo

        val name2 = teams.second.name
        val logo2 = teams.second.logo

        val teamPropertiesList = listOf(name1, logo1, name2, logo2)

        return teamPropertiesList.joinToString("~")
    }

    @TypeConverter
    fun readTeamPairFromRoom(roomString: String): Pair<Team, Team> {

        val teamPropertiesList = roomString.split("~")
            .map { it }

        val name1 = teamPropertiesList[0]
        val logo1 = teamPropertiesList[1]

        val name2 = teamPropertiesList[2]
        val logo2 = teamPropertiesList[3]

        return Pair(
            Team(name = name1, logo = logo1),
            Team(name = name2, logo = logo2)
        )
    }
}

@TypeConverter
fun writeLeagueToRoom(league: League): String {

    val leagueId = league.id.toString()
    val leagueName = league.name
    val leagueCountry = league.country
    val leagueLogo = league.leagueLogo
    val countryFlag = league.countryFlag

    val leaguePropertiesList = listOf(leagueId, leagueName, leagueCountry, leagueLogo, countryFlag)

    return leaguePropertiesList.joinToString("~")
}

@TypeConverter
fun readLeagueFromRoom(roomString: String): League {

    val leaguePropertiesList = roomString.split("~")
        .map { it }
    val leagueId = leaguePropertiesList[0]
    val leagueName = leaguePropertiesList[1]
    val leagueCountry = leaguePropertiesList[2]
    val leagueLogo = leaguePropertiesList[3]
    val countryFlag = leaguePropertiesList[4]

    return League(
        id = leagueId.toInt(),
        name = leagueName,
        country = leagueCountry,
        leagueLogo = leagueLogo,
        countryFlag = countryFlag
    )
}

@TypeConverter
fun writeGoalToRoom(goal: Goal): String {

    val homeTeamScore = goal.homeTeamScore.toString()
    val awayTeamScore = goal.awayTeamScore.toString()

    val goalPropertiesList = listOf(homeTeamScore, awayTeamScore)

    return goalPropertiesList.joinToString("~")
}

@TypeConverter
fun readGoalFromRoom(roomString: String): Goal {

    val goalPropertiesList = roomString.split("~").map { it }

    val homeTeamScore = goalPropertiesList[0].toInt()
    val awayTeamScore = goalPropertiesList[1].toInt()

    return Goal(homeTeamScore = homeTeamScore, awayTeamScore = awayTeamScore)
}
