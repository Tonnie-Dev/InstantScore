package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Stats(val type: String, val value: Int) : Parcelable
