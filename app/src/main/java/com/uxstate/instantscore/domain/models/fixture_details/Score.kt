package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Score(

val extraTimeScore: ExtraTime,
val fullTimeScore: FullTime,
val penaltyShootOutScore: PenaltyShootOut
):Parcelable
