package com.uxstate.instantscore.data.json


import com.uxstate.instantscore.domain.models.fixture_details.*
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton

// force single instance of FixtureDetailsJsonParser for the entire app process
@Singleton

/*
Use @Inject so that Hilt knows how to create CountryRepositoryImpl object
noting we will be injecting the interface and not the impl
*/

// always favor/depend on abstractions instead of concrete classes
class FixtureDetailsJsonParser @Inject constructor() : JsonStringParser<FixtureDetails> {
    override fun parseJsonToFixtureDetails(jsonString: String): FixtureDetails {

        val jsonMainFixturesObject = JSONObject(jsonString)
        val responseJsonArray = jsonMainFixturesObject.getJSONArray("response")
        val fixtureJsonObject = responseJsonArray.getJSONObject(0)

        // variable
        val fixtureId = fixtureJsonObject.getInt("id")

        // variable
        val timeStamp = fixtureJsonObject.getLong("timestamp")

        // variable
        val referee = fixtureJsonObject.getString("fixture")

        val venueJsonObject = fixtureJsonObject.getJSONObject("venue")

        // variable
        val venue = venueJsonObject.optString("name", "")

        val statusJsonObject = fixtureJsonObject.getJSONObject("status")

        // variable
        val status = statusJsonObject.optString("short", "")

        // variable
        val timeElapsed = statusJsonObject.optInt("elapsed", -1)

        val goalJsonObject = responseJsonArray.getJSONObject(3)

        // variable
        val homeGoals = goalJsonObject.optInt("home", -1)

        // variable
        val awayGoals = goalJsonObject.optInt("away", -1)

        val leagueJsonObject = responseJsonArray.getJSONObject(1)

        // variable
        val leagueName = leagueJsonObject.optString("name", "")

        val teamJsonObject = responseJsonArray.getJSONObject(2)

        val homeTeamJSONObject = teamJsonObject.getJSONObject("home")
        val awayTeamJSONObject = teamJsonObject.getJSONObject("away")

        // variables
        val homeTeam: Team = Team(
                name = homeTeamJSONObject.optString("name", ""),
                logo = homeTeamJSONObject.optString("logo", ""),
                isWinner = homeTeamJSONObject.optBoolean("winner")
        )
        val awayTeam: Team = Team(
                name = awayTeamJSONObject.optString("name", ""),
                logo = awayTeamJSONObject.optString("logo", ""),
                isWinner = awayTeamJSONObject.optBoolean("winner")
        )
        val teamPair = Pair(
                first = homeTeam, second = awayTeam
        )

        val eventsJsonArray = responseJsonArray.getJSONArray(5)
        val events = mutableListOf<Event>()
        (0 until eventsJsonArray.length()).forEach { i ->

            val innerEventObj = eventsJsonArray.getJSONObject(i)

            innerEventObj.keys()
                    .forEach { key ->

                        // variables
                        val timeJsonObj = innerEventObj.getJSONObject("time")
                        val teamJsonObj = innerEventObj.getJSONObject("team")
                        val playerJsonObj = innerEventObj.getJSONObject("player")
                        val assistJsonObj = innerEventObj.getJSONObject("assist")
                        val typeJsonObj = innerEventObj.getJSONObject("type")
                        val detailJsonObj = innerEventObj.getJSONObject("detail")

                        val event = Event(
                                timeElapsed = timeJsonObj.optInt("elapsed", -1),
                                inExtra = teamJsonObj.optInt("extra", -1),
                                player = playerJsonObj.optString("name", ""),
                                side = teamJsonObj.optString("name", ""),
                                assist = assistJsonObj.optString("name", ""),
                                eventType = typeJsonObj.optString("type", ""),
                                eventDetail = detailJsonObj.optString("detail", "")
                        )

                        events.add(event)
                    }
        }

        val statsJsonArray = responseJsonArray.getJSONArray(7)
        val stats = mutableListOf<Stats>()
        for (i in 0 until statsJsonArray.length()) {
            val innerStatsObj = statsJsonArray.getJSONObject(i)

            val teamJsonObj = innerStatsObj.getJSONObject("team")

            // variable
            val side = teamJsonObj.optString("name")

            val statsArray = innerStatsObj.getJSONArray("statistics")

            (0 until statsArray.length()).mapTo(stats) {
                val stat = statsArray.getJSONObject(it)

                Stats(
                        side = side,
                        possession = stat.optInt("value", -1),
                        shotsOnGoal = stat.optInt("value", -1),
                        shotsOffGoal = stat.optInt("value", -1),
                        totalShots = stat.optInt("value", -1),
                        cornerKicks = stat.optInt("value", -1),
                        offSides = stat.optInt("value", -1),
                        fouls = stat.optInt("value", -1),
                        yellowCards = stat.optInt("value", -1),
                        redCards = stat.optInt("value", -1),
                )
            }
            /* (0 until statsArray.length()).forEach {

                 val stat = statsArray.getJSONObject(it)

                 val shotsOnGoal = stat.
             }*/
        }

        val lineUpsJsonArray = responseJsonArray.getJSONArray(6)
        //variable
        val startingElevenLineUp = mutableListOf<Player>()
        val substitutesLineUp = mutableListOf<Player>()

        for (i in 0 until lineUpsJsonArray.length()) {

            val innerLineUpsObj = lineUpsJsonArray.getJSONObject(i)

            val teamJsonObj = innerLineUpsObj.getJSONObject("team")

            // variables
            val teamName = teamJsonObj.optString("name", "")
            val teamLogo = teamJsonObj.optString("logo", "")


            val coachJsonObj = innerLineUpsObj.getJSONObject("coach")

            //variable
            val coachName = coachJsonObj.optString("name", "")
            val coachPhoto = coachJsonObj.optString("photo", "")

            val startingElevenArray = innerLineUpsObj.getJSONArray("startXI")

            for (j in 0 until startingElevenArray.length()) {

                val innerStartingElevenObj = startingElevenArray.getJSONObject(j)
                val startingPlayerJsonObj = innerLineUpsObj.getJSONObject("player")

                //variables
                val playerId = startingPlayerJsonObj.optInt("id", -1)
                val playerName = startingPlayerJsonObj.optString("name", "")
                val playerNumber = startingPlayerJsonObj.optInt("number", -1)
                val playerPosition = startingPlayerJsonObj.optString("pos", "")

                val startingPlayer = Player(
                        playerId = playerId,
                        playerName = playerName,
                        playerNumber = playerNumber,
                        playerPosition = playerPosition
                )
                startingElevenLineUp.add(startingPlayer)
            }

            val subsArray = innerLineUpsObj.getJSONArray("substitutes")
            for (j in 0 until subsArray.length()) {

                val subsInnerJsonObj = subsArray.getJSONObject(j)
                val subPlayerJsonObj = subsInnerJsonObj.getJSONObject("player")
                //variables
                val playerId = subPlayerJsonObj.optInt("id", -1)
                val playerName = subPlayerJsonObj.optString("name", "")
                val playerNumber = subPlayerJsonObj.optInt("number", -1)
                val playerPosition = subPlayerJsonObj.optString("pos", "")

                val subPlayer = Player(
                        playerId = playerId,
                        playerName = playerName,
                        playerNumber = playerNumber,
                        playerPosition = playerPosition
                )


                substitutesLineUp.add(subPlayer)
            }
        }

        val scoreJsonObject = responseJsonArray.getJSONObject(3)

        val fullTimeJsonObj = scoreJsonObject.getJSONObject("fulltime")
        val extraTimeJsonObj = scoreJsonObject.getJSONObject("extratime")
        val penaltiesJsonObj = scoreJsonObject.getJSONObject("penalty")

        //variables
        val fullTimeHomeScore = fullTimeJsonObj.optInt("home", -1)
        val fullTimeAwayScore = fullTimeJsonObj.optInt("away", -1)

        val extraTimeHomeScore = extraTimeJsonObj.optInt("home", -1)
        val extraTimeAwayScore = extraTimeJsonObj.optInt("away", -1)


        val penaltiesHomeScore = penaltiesJsonObj.optInt("home", -1)
        val penaltiesAwayScore = penaltiesJsonObj.optInt("awa", -1)


        return FixtureDetails(
                fixtureId = fixtureId,
                timeStamp = timeStamp,
                referee = referee,
                venue = venue,
                status = status,
                timeElapsed = timeElapsed,
                homeGoals = homeGoals,
                awayGoals = awayGoals,
                leagueName = leagueName,
                teams =teamPair,
                events = events,
                stats = Stats(
                        side = "",
                        possession = 0,
                        shotsOnGoal = 0,
                        shotsOffGoal = 0,
                        totalShots = 0,
                        cornerKicks = 0,
                        offSides = 0,
                        fouls = 0,
                        yellowCards = 0,
                        redCards = 0
                ),
                lineUps = listOf(),
                score = Score(
                        extraTimeScore = ExtraTime(
                                extraTimeAwayScore = 0,
                                extraTimeHomeScore = 0
                        ), fullTimeScore = FullTime(
                        fullTimeAwayScore = 0,
                        fullTimeHomeScore = 0
                ), penaltyShootOutScore = PenaltyShootOut(
                        penaltiesScoredAway = 0,
                        penaltiesScoredHome = 0
                )
                )
        )


    }
}

data class SomeItem(val type: String, val value: Int)