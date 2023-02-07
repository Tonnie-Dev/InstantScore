package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import java.time.LocalDate
import javax.inject.Inject
import org.json.JSONObject

class LiveFixturesJsonParser @Inject constructor() : JsonStringParser<MutableList<Fixture>> {
    override fun parsJsonString(jsonString: String): MutableList<Fixture> {

        val mainJsonObj = JSONObject(jsonString)
        val responseJsonArray = mainJsonObj.getJSONArray("response")

        // initialize empty list
        val fixtures = mutableListOf<Fixture>()

        (0 until responseJsonArray.length()).forEach { i ->

            val innerJsonObj = responseJsonArray.getJSONObject(i)

            val fixtureJsonObj = innerJsonObj.getJSONObject("fixture")

            // construct individual fixture with each iteration

            // variable - id, date, time
            val fixtureId = fixtureJsonObj.optInt("id", -1)
            val date = LocalDate.now()
            val startTime = fixtureJsonObj.optInt("timestamp", -1)

            val statusJsonObj = fixtureJsonObj.getJSONObject("status")

            // variable - status
            val status = Status(
                fixtureLong = statusJsonObj.optString("long", ""),
                fixtureShort = statusJsonObj.optString("short", ""),
                timeElapsed = statusJsonObj.optInt("elapsed", -1)
            )

            val leagueJsonObj = innerJsonObj.getJSONObject("league")

            // variables - leagueId, name, country, leagueLogo,countryFlag,season
            val leagueId = leagueJsonObj.optInt("id", -1)
            val leagueName = leagueJsonObj.optString("name", "")
            val country = leagueJsonObj.optString("country", "")
            val leagueLogo = leagueJsonObj.optString("logo", "")
            val countryFlag = leagueJsonObj.optString("flag", "")
            val season = leagueJsonObj.optInt("season", -1)

            val league = League(
                id = leagueId,
                name = leagueName,
                country = country,
                leagueLogo = leagueLogo,
                countryFlag = countryFlag,
                season = season
            )

            val teamsJsonObj = innerJsonObj.getJSONObject("teams")
            val homeTeamJsonObj = teamsJsonObj.getJSONObject("home")
            val awayTeamJsonObj = teamsJsonObj.getJSONObject("away")

            // variable - teams
            val teams = Pair(
                first = Team(
                    name = homeTeamJsonObj.optString("name"),
                    logo = homeTeamJsonObj.optString("logo")
                ),
                second = Team(
                    name = awayTeamJsonObj.optString("name"),
                    logo = awayTeamJsonObj.optString("logo")
                )
            )

            val goalsJsonObj = innerJsonObj.getJSONObject("goals")

            // variable - goals
            val goals = Goal(
                homeTeamScore = goalsJsonObj.optInt("home", -1),
                awayTeamScore = goalsJsonObj.optInt("away", -1)
            )

            // add fixture object to live fixtures list (mutable)

            fixtures.add(
                Fixture(
                    fixtureId = fixtureId,
                    date = date,
                    startTime = startTime.toLong(),
                    status = status,
                    league = league,
                    teams = teams,
                    goals = goals
                )
            )
        }
        return fixtures
    }
}