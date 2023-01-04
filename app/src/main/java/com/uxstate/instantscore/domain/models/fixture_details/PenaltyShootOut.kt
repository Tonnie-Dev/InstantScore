package com.uxstate.instantscore.domain.models.fixture_details

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PenaltyShootOut (val penaltiesScoredAway: Int,
                      val penaltiesScoredHome: Int,

                      ) : Parcelable