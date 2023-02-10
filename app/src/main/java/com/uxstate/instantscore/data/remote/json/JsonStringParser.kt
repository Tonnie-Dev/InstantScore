package com.uxstate.instantscore.data.remote.json

interface JsonStringParser<T> {

    suspend fun parsJsonString(jsonString: String): T
}