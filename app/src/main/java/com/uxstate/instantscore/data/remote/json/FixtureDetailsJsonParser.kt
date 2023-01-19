package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.fixture_details.*
import javax.inject.Inject
import javax.inject.Singleton
import org.json.JSONObject

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
        val responseJsonObject = responseJsonArray.getJSONObject(0)

        val fixtureJsonObject = responseJsonObject.getJSONObject("fixture")

        // variable - id
        val fixtureId = fixtureJsonObject.optInt("id", -1)

        // variable - timestamp
        val timeStamp = fixtureJsonObject.optLong("timestamp", 0L)

        // variable - referee
        val referee = fixtureJsonObject.optString("referee", "")

        val venueJsonObject = fixtureJsonObject.getJSONObject("venue")

        // variable - venue
        val venue = venueJsonObject.optString("name", "")

        val statusJsonObject = fixtureJsonObject.getJSONObject("status")

        // variable -  short
        val status = statusJsonObject.optString("short", "")

        // variable - time elapsed
        val timeElapsed = statusJsonObject.optInt("elapsed", -1)

        val goalJsonObject = responseJsonObject.getJSONObject("goals")

        // variable - home goal
        val homeGoals = goalJsonObject.optInt("home", -1)

        // variable - away goal
        val awayGoals = goalJsonObject.optInt("away", -1)

        val leagueJsonObject = responseJsonObject.getJSONObject("league")

        // variable - league name
        val leagueName = leagueJsonObject.optString("name", "")

        val teamJsonObject = responseJsonObject.getJSONObject("teams")

        val homeTeamJSONObject = teamJsonObject.getJSONObject("home")
        val awayTeamJSONObject = teamJsonObject.getJSONObject("away")

        // variables
        val homeTeam = Team(
            name = homeTeamJSONObject.optString("name", ""),
            logo = homeTeamJSONObject.optString("logo", ""),
            isWinner = homeTeamJSONObject.optBoolean("winner", false)
        )
        val awayTeam = Team(
            name = awayTeamJSONObject.optString("name", ""),
            logo = awayTeamJSONObject.optString("logo", ""),
            isWinner = awayTeamJSONObject.optBoolean("winner", false)
        )

        // variable teams Pair
        val teamPair = Pair(
            first = homeTeam, second = awayTeam
        )

        val eventsJsonArray = responseJsonObject.getJSONArray("events")
        val events = mutableListOf<Event>()
        (0 until eventsJsonArray.length()).forEach { i ->

            val innerEventObj = eventsJsonArray.getJSONObject(i)

            var event: Event? = null
            innerEventObj.keys()
                .forEach { _ ->

                    val timeJsonObj = innerEventObj.getJSONObject("time")
                    val teamJsonObj = innerEventObj.getJSONObject("team")
                    val playerJsonObj = innerEventObj.getJSONObject("player")
                    val assistJsonObj = innerEventObj.getJSONObject("assist")

                    event = Event(
                        timeElapsed = timeJsonObj.optInt("elapsed", -1),
                        inExtra = timeJsonObj.optInt("extra", -1),
                        player = playerJsonObj.optString("name", ""),
                        side = teamJsonObj.optString("name", ""),
                        assist = assistJsonObj.optString("name", "G"),
                        eventType = innerEventObj.optString("type"),
                        eventDetail = innerEventObj.optString("detail")
                    )
                }

            event?.let {

                events.add(it)
            }
        }

        val statsJsonArray = responseJsonObject.getJSONArray("statistics")

        // variable - Stats List
        val stats = mutableListOf<Stats>()

        for (i in 0 until statsJsonArray.length()) {

            val innerStatsObj = statsJsonArray.getJSONObject(i)

            val statsArray = innerStatsObj.getJSONArray("statistics")

            for (j in 0 until statsArray.length()) {

                val innerStatObj = statsArray.getJSONObject(j)

                // variable
                val type = innerStatObj.optString("type", "")

                val statValue = if (type == "Ball Possession") {

                    innerStatObj.getString("value")
                        .substringBefore("%").toInt()
                } else {
                    innerStatObj.optInt("value", 0)
                }
                // val statValue = innerStatObj.optInt("value", 0)

                val stat = Stats(type, statValue)

                stats.add(stat)
            }
        }

        val lineUpsJsonArray = responseJsonObject.getJSONArray("lineups")

        // variable
        val teamLineUps = mutableListOf<LineUp>()

        for (i in 0 until lineUpsJsonArray.length()) {

            // cleanup list with each iteration to construct a fresh line-up object
            val startingElevenLineUp = mutableListOf<Player>()
            val substitutesLineUp = mutableListOf<Player>()

            val innerLineUpsObj = lineUpsJsonArray.getJSONObject(i)

            val teamJsonObj = innerLineUpsObj.getJSONObject("team")
            val colorsJsonObj = teamJsonObj.getJSONObject("colors")
            val playerColorJsonObj = colorsJsonObj.getJSONObject("player")

            // variables
            val teamName = teamJsonObj.optString("name", "")
            val teamLogo = teamJsonObj.optString("logo", "")
            val primaryPlayerColor = playerColorJsonObj.optString("primary", "D3D3D3")

            val coachJsonObj = innerLineUpsObj.getJSONObject("coach")

            // variable
            val coachName = coachJsonObj.optString("name", "")
            val coachPhoto = coachJsonObj.optString("photo", "")

            val startingElevenArray = innerLineUpsObj.getJSONArray("startXI")

            for (j in 0 until startingElevenArray.length()) {

                val innerStartingElevenObj = startingElevenArray.getJSONObject(j)
                val startingPlayerJsonObj = innerStartingElevenObj.getJSONObject("player")

                // variables
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

            val subsJsonArray = innerLineUpsObj.getJSONArray("substitutes")

            for (k in 0 until subsJsonArray.length()) {

                val subsInnerJsonObj = subsJsonArray.getJSONObject(k)
                val subPlayerJsonObj = subsInnerJsonObj.getJSONObject("player")
                // variables
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

            val lineup = LineUp(
                coach = Coach(
                    name = coachName,
                    photo = coachPhoto
                ),
                startingXI = startingElevenLineUp, substitutes = substitutesLineUp,

                team = Team(
                    name = teamName,
                    logo = teamLogo,
                    isWinner = false
                ),
                teamColor = primaryPlayerColor
            )

            teamLineUps.add(lineup)
        }

        val scoreJsonObject = responseJsonObject.getJSONObject("score")

        val fullTimeJsonObj = scoreJsonObject.getJSONObject("fulltime")
        val extraTimeJsonObj = scoreJsonObject.getJSONObject("extratime")
        val penaltiesJsonObj = scoreJsonObject.getJSONObject("penalty")

        // variables
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
            teams = teamPair,
            events = events,
            lineUps = teamLineUps,
            score = Score(
                extraTimeScore = ExtraTime(
                    extraTimeAwayScore = extraTimeAwayScore,
                    extraTimeHomeScore = extraTimeHomeScore
                ),
                fullTimeScore = FullTime(
                    fullTimeAwayScore = fullTimeAwayScore,
                    fullTimeHomeScore = fullTimeHomeScore
                ),
                penaltyShootOutScore = PenaltyShootOut(
                    penaltiesScoredAway = penaltiesAwayScore,
                    penaltiesScoredHome = penaltiesHomeScore
                )
            ),
            stats = stats
        )
    }
}
