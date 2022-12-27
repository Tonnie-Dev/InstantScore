package com.uxstate.instantscore.data.remote.dtos.stackoverflow

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Product(
    @Json(name = "id")
    val id: String,
    @Json(name = "product_name")
    val productName: String,
    @Json(name = "product_price")
    val productPrice: String,
    @Json(name = "product_quantity")
    val productQuantity: Int,
    @Json(name = "product_total_price")
    val productTotalPrice: String
)