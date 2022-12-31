package com.uxstate.instantscore.utils

import java.time.*
import java.time.format.DateTimeFormatter

// Extension function on LocalDateTime class to human readable date
fun LocalDate.toStringDate(): String {

    val pattern = "yyyy-MM-dd"
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(dateFormatter)
}

// Extension function on String class to LocalDateTime
fun String.toLocalDate(): LocalDateTime {

    val pattern = "yyyy-MM-dd'T'HH:mm:ss"
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    return LocalDateTime.parse(this, dateFormatter)
}

// Extension to convert Long Timestamp to ZDT
fun Long.toZonedDateTime(): ZonedDateTime {

    val zoneId = ZoneId.systemDefault()

    // millis
    val instant = Instant.ofEpochSecond(this)

    return ZonedDateTime.ofInstant(instant, zoneId)
}

fun ZonedDateTime.toCustomLocalDate(): LocalDate {
    return this.toLocalDateTime().toLocalDate()
}