package com.uxstate.instantscore.data.json

import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails

interface JsonStringParser<T> {

    fun parseJsonToFixtureDetails(jsonString: String): T
}