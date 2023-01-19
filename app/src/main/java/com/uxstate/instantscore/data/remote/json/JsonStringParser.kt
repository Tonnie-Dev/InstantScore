package com.uxstate.instantscore.data.remote.json

interface JsonStringParser<T> {

    fun parseJsonToFixtureDetails(jsonString: String): T
}