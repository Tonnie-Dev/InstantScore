package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.models.standings.Team
import javax.inject.Inject
import org.json.JSONObject

class StandingsJsonParser @Inject constructor() : JsonStringParser<MutableList<Standing>> {
    override fun parsJsonString(jsonString: String): MutableList<Standing> {

        val mainJsonStandingsResponseObj = JSONObject(jsonString)

        val responseJsonArray = mainJsonStandingsResponseObj.getJSONArray("response")
        val innerResponseObj = responseJsonArray.getJSONObject(0)
        val leagueObj = innerResponseObj.getJSONObject("league")

        // league name
        val leagueId = leagueObj.optInt("id", -1)
        val leagueName = leagueObj.optString("name", "")
        val country = leagueObj.optString("country", "")
        val leagueLogo = leagueObj.optString("logo", "")
        val countryFlag = leagueObj.optString("flag", "")
        val season = leagueObj.optInt("season", -1)

        val standingsJsonArray = leagueObj.getJSONArray("standings")
        val innerJsonStandingArray = standingsJsonArray.getJSONArray(0)

        val standings = mutableListOf<Standing>()

        (0 until innerJsonStandingArray.length()).forEach { i ->

            val innerJsonObj = innerJsonStandingArray.getJSONObject(i)

            // variable - rank
            val rank = innerJsonObj.optInt("rank", -1)
            val teamObj = innerJsonObj.getJSONObject("team")

            // variables - id, name and logo
            val teamId = teamObj.optInt("id", -1)
            val teamName = teamObj.optString("name", "")
            val teamLogo = teamObj.optString("logo", "")

            // variables - points, goal difference, group, description

            val points = innerJsonObj.optInt("points", -1)
            val goalsDifference = innerJsonObj.optInt("goalsDiff", -1000)
            val group = innerJsonObj.optString("group", "")
            val description = innerJsonObj.optString("description", "")

            val allJsonObj = innerJsonObj.getJSONObject("all")

            val matchPlayed = allJsonObj.optInt("played", -1)
            val goalsJsonObj = allJsonObj.getJSONObject("goals")

            // variables - goals for and goals against

            val goalsFor = goalsJsonObj.optInt("for", -1)
            val goalsAgainst = goalsJsonObj.optInt("against", -1)

            val standing = Standing(
                description = description,
                goalsAgainst = goalsAgainst,
                goalsFor = goalsFor,
                goalsDiff = goalsDifference,
                matchPlayed = matchPlayed,
                group = group,
                points = points,
                rank = rank,
                team = Team(
                    id = teamId,
                    logo = teamLogo,
                    name = teamName
                )
            )

            standings.add(standing)
        }

        return standings
    }
}