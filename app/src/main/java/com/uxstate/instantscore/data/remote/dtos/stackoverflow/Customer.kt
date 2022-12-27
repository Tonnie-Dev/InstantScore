package com.uxstate.instantscore.data.remote.dtos.stackoverflow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Customer(
    @Json(name = "customer_name")
    val customerName: String,
    @Json(name = "customer_phone")
    val customerPhone: String
)