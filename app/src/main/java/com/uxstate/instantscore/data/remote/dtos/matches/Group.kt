package com.uxstate.instantscore.data.remote.dtos.matches


import com.squareup.moshi.Json

data class Group(
    @Json(name = "group_id")
    val groupId: Int,
    @Json(name = "group_name")
    val groupName: String
)