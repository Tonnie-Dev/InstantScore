package com.uxstate.instantscore.data.json

import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.models.fixture_details.Team
import org.json.JSONObject
import javax.inject.Inject
import javax.inject.Singleton


//force single instance of FixtureDetailsJsonParser for the entire app process
@Singleton

/*
Use @Inject so that Hilt knows how to create CountryRepositoryImpl object
noting we will be injecting the interface and not the impl
*/

//always favor/depend on abstractions instead of concrete classes
class FixtureDetailsJsonParser @Inject constructor() : JsonStringParser<FixtureDetails> {
    override fun parseJsonToFixtureDetails(jsonString: String): FixtureDetails {

        val jsonMainFixturesObject = JSONObject(jsonString)
        val responseJsonArray = jsonMainFixturesObject.getJSONArray("response")
        val fixtureJsonObject = responseJsonArray.getJSONObject(0)


        //variable
        val fixtureId = fixtureJsonObject.getInt("id")

        //variable
        val timeStamp = fixtureJsonObject.getLong("timestamp")

        //variable
        val referee = fixtureJsonObject.getString("fixture")

        val venueJsonObject = fixtureJsonObject.getJSONObject("venue")


        //variable
        val venue = venueJsonObject.optString("name", "")


        val statusJsonObject = fixtureJsonObject.getJSONObject("status")

        //variable
        val status = statusJsonObject.optString("short", "")

        //variable
        val timeElapsed = statusJsonObject.optInt("elapsed", -1)


        val goalJsonObject = responseJsonArray.getJSONObject(3)

        //variable
        val homeGoals = goalJsonObject.optInt("home", -1)

        //variable
        val awayGoals = goalJsonObject.optInt("away", -1)


        val leagueJsonObject = responseJsonArray.getJSONObject(1)

        //variable
        val leagueName = leagueJsonObject.optString("name", "")


        val teamJsonObject = responseJsonArray.getJSONObject(2)

        val homeTeamJSONObject = teamJsonObject.getJSONObject("home")
        val awayTeamJSONObject = teamJsonObject.getJSONObject("away")

        //variables
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
        (0..eventsJsonArray.length()).forEach { i ->

            val currentSubObj = eventsJsonArray.getJSONObject(i)

            currentSubObj.keys()
                    .forEach { key ->

                        val timeJsonObj = currentSubObj.getJSONObject("time")
                        val teamJsonObj = currentSubObj.getJSONObject("team")
                        val playerJsonObj = currentSubObj.getJSONObject("player")
                        val assistJsonObj = currentSubObj.getJSONObject("assist")
                        val typeJsonObj = currentSubObj.getJSONObject("type")
                        val detailJsonObj = currentSubObj.getJSONObject("detail")


                        val event = Event(
                                timeElapsed = timeJsonObj.optInt("elapsed", -1),
                                inExtra = teamJsonObj.optInt("extra", -1),
                                player = playerJsonObj.optString("name",""),
                                side = teamJsonObj.optString("name",""),
                                assist = assistJsonObj.optString("name", ""),
                                eventType = typeJsonObj.optString("type",""),
                                eventDetail = detailJsonObj.optString("detail","")
                        )

                        events.add(event)

                    }

        }

        val statsJsonArray = responseJsonArray.getJSONArray(7)

        for (i in 0..statsJsonArray.length()){
            val innerStatObj = statsJsonArray.getJSONObject(i)

        }

        TODO("Not yet implemented")
    }
}