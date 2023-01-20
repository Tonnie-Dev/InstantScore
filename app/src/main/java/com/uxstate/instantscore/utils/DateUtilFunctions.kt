package com.uxstate.instantscore.utils

import java.time.*
import java.time.format.DateTimeFormatter

// Extension function on LocalDateTime class to human readable date
fun LocalDate.toReverseStringDate(): String {

    val pattern = "yyyy-MM-dd"
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(dateFormatter)
}


fun LocalDate.toRegularStringDate(): String {

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
    return this.toLocalDateTime()
        .toLocalDate()
}

fun Long.toHourMinuteFormat(): String {
    val zoneId = ZoneId.systemDefault()
    val instant = Instant.ofEpochSecond(this)
    val zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId)
    val localDateTime = zonedDateTime.toLocalDateTime()
    val hour = formatTimeDisplay(localDateTime.hour)
    val minute = formatTimeDisplay(localDateTime.minute)

    return "$hour:$minute"
}

fun formatTimeDisplay(timeUnit: Int): String {

    return if (timeUnit in (0..9)) "0$timeUnit" else "$timeUnit"
}