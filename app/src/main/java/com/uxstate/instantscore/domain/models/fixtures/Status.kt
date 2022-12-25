package com.uxstate.instantscore.domain.models.fixtures

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Status(
    val fixtureLong: String,
    val fixtureShort: String,
    val timeElapsed: Int
): Parcelable
