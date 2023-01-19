package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Event(
    val timeElapsed: Int,
    val inExtra: Int,
    val player: String,
    val side: String,
    val assist: String?,
    val eventType: String,
    val eventDetail: String
) : Parcelable