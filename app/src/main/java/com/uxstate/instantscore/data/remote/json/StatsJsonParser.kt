package com.uxstate.instantscore.data.remote.json

import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import javax.inject.Inject

class StatsJsonParser@Inject constructor():JsonStringParser<MutableList<PlayerStats>> {
    override fun parsJsonString(jsonString: String): MutableList<PlayerStats> {
        TODO("Not yet implemented")
    }
}