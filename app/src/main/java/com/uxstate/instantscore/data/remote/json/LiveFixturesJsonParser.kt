package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import org.json.JSONObject
import java.time.LocalDate

class LiveFixturesJsonParser:JsonStringParser<MutableList<Fixture>> {
    override fun parsJsonString(jsonString: String): MutableList<Fixture> {

        val mainJsonObj = JSONObject(jsonString)
        val responseJsonArray = mainJsonObj.getJSONArray("response")

        //initialize empty list
        val fixtures = mutableListOf<Fixture>()

        (0 until responseJsonArray.length()).forEach { i ->

            val innerJsonObj = responseJsonArray.getJSONObject(i)

            val fixtureJsonObj = innerJsonObj.getJSONObject("fixture")

            //construct individual fixture with each iteration

            //variable - id, date, time
            val fixtureId = fixtureJsonObj.optInt("id", -1)
            val date = LocalDate.now()
            val startTime = fixtureJsonObj.optInt("timestamp", -1 )

val statusJsonObj = fixtureJsonObj.getJSONObject("status")
            
            //variable - status
            val status = Status(fixtureLong = statusJsonObj.optString("long",""), fixtureShort = statusJsonObj.optString("short",""), timeElapsed = 0)
        }
        TODO("Not yet implemented")
    }


}