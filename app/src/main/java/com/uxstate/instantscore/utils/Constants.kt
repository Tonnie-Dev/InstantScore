package com.uxstate.instantscore.utils

const val BASE_URL = "https://api-football-v1.p.rapidapi.com/"

// Headers
const val API_KEY = "ac94f94bb2msh209b8322dafe16ep19e183jsnabc6710bd5a9"
const val X_RAPID_KEY = "X-RapidAPI-Key"
const val X_RAPID_HOST = "X-RapidAPI-Host"
const val HOST_VALUE = "api-football-v1.p.rapidapi.com"

// Endpoints
const val GET_FIXTURES = "v3/fixtures"
const val GET_STANDINGS = "v3/standings"
const val GET_LIVE_FIXTURES = "v3/fixtures"
const val GET_TOP_SCORERS = "v3/players/{stat_type}"

// Timeouts
const val READ_TIMEOUT = 15L
const val CONNECT_TIMEOUT = 15L

// Work
const val SCORES_WORKER_ERROR_KEY = "scores_worker_error"

// Database
const val DATABASE_NAME = "scores_database"
const val DEFAULT_LEAGUE_ID = 39
const val DEFAULT_SEASON = 2022
const val DEFAULT_FIXTURE_ID = 867954
