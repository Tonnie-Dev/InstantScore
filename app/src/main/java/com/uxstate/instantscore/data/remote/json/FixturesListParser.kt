package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.fixtures.Fixture
import javax.inject.Inject

class FixturesListParse @Inject constructor() : JsonStringParser<Fixture> {
    override suspend fun parseJsonString(jsonString: String): List<Fixture> {
        TODO("Not yet implemented")
    }


}