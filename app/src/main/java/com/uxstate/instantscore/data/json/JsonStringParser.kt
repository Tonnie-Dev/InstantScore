package com.uxstate.instantscore.data.json

interface JsonStringParser<T> {

    fun parseJsonToFixtureDetails(jsonString: String): T
}