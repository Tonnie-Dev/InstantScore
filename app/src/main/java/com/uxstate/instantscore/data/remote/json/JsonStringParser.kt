package com.uxstate.instantscore.data.remote.json

interface JsonStringParser<T> {

    fun parsJsonString(jsonString: String): T
}