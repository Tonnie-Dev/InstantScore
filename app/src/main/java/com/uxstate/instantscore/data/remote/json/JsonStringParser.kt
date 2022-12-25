package com.uxstate.instantscore.data.remote.json

interface JsonStringParser<T> {

    suspend fun parseJsonString(jsonString: String): List<T>
}