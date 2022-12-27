package com.uxstate.instantscore.data.remote.dtos.stackoverflow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Payment(
    @Json(name = "payment_amount")
    val paymentAmount: String,
    @Json(name = "payment_date")
    val paymentDate: String,
    @Json(name = "payment_mode")
    val paymentMode: String
)