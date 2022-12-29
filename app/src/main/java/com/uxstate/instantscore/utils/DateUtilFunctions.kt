package com.uxstate.instantscore.utils

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

//Extension function on LocalDateTime class to human readable date
fun LocalDate.toStringDate():String{

    val pattern = "yyyy-MM-dd"
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(dateFormatter)
}


//Extension function on String class to LocalDateTime
fun String.toLocalDate(): LocalDateTime {

    val pattern = "yyyy-MM-dd'T'HH:mm:ss"
    val dateFormatter = DateTimeFormatter.ofPattern(pattern)
    return LocalDateTime.parse(this, dateFormatter)

}