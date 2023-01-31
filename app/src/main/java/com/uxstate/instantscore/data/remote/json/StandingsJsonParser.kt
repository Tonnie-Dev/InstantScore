package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.standings.Standing
import org.json.JSONObject

class StandingsJsonParser:JsonStringParser<Standing> {
    override fun parseJsonToFixtureDetails(jsonString: String): Standing {

        val mainJsonStandingsResponseObj = JSONObject(jsonString)

val responseJsonArray = mainJsonStandingsResponseObj.getJSONArray("response")
        val responseInnerObj = responseJsonArray.getJSONObject(0)
        val leagueObj = responseInnerObj.getJSONObject("league")

        TODO("Not yet implemented")
    }


}