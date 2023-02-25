package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import javax.inject.Inject
import org.json.JSONObject

class StatsJsonParser @Inject constructor() : JsonStringParser<MutableList<PlayerStats>> {
    override suspend fun parseJsonString(jsonString: String): MutableList<PlayerStats> {
        // to get the mainJsonObject pass the raw JSON String from the API

        val mainJsonObject = JSONObject(jsonString)

        // with the main Json object get the response array passing "response" as the key

        val responseJsonArray = mainJsonObject.getJSONArray("response")

        // at this point you want to iterate the contents of the responseJsonArray - use
        // until ArrayOutOfIndex exception

        // initilize an empty mutable list just outside the forEach loop

        val playerStatsList = mutableListOf<PlayerStats>()
        (0 until responseJsonArray.length()).forEach { i ->

            // use the position of the object inside the JsonArray to get the current object
            // during iteration

            val innerResponseJsonObj = responseJsonArray.getJSONObject(i)

            // use "player" as the key to get the player Json Object
            val playerJsonObj = innerResponseJsonObj.getJSONObject("player")

            // variables - playerName, playerPhoto
            val playerName = playerJsonObj.optString("name", "")
            val playerPhoto = playerJsonObj.optString("photo", "")

            val statisticsJsonArray = innerResponseJsonObj.getJSONArray("statistics")

            val innerStatisticsJsonObj = statisticsJsonArray.getJSONObject(0)

            val teamObj = innerStatisticsJsonObj.getJSONObject("team")

            // variables - teamName, teamLogo
            val teamName = teamObj.optString("name", "")
            val teamLogo = teamObj.optString("logo", "")

            val goalsJsonObj = innerStatisticsJsonObj.getJSONObject("goals")

            // variables - goals, assists
            val goals = goalsJsonObj.optInt("total", -1)
            val assists = goalsJsonObj.optInt("assists", -1)

            val cardsJsonObj = innerStatisticsJsonObj.getJSONObject("cards")
            // variables - yellowCards, redCards

            val yellowCards = cardsJsonObj.optInt("yellow", -1)
            val redCards = cardsJsonObj.optInt("red", -1)

            val playerStats = PlayerStats(
                rank = i + 1,
                playerName = playerName,
                playerPhoto = playerPhoto,
                teamName = teamName,
                teamLogo = teamLogo,
                goals = goals,
                assists = assists,
                yellowCards = yellowCards,
                redCards = redCards
            )

            playerStatsList.add(playerStats)
        }

        return playerStatsList
    }
}