package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.player_stats.PlayerStats
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetStatsUseCase(private val repository: ScoresRepository) {
    operator fun invoke(leagueId: Int, season: Int): Flow<Resource<List<PlayerStats>>> {

        return repository.getTopScorers(leagueId = leagueId, season = season)
    }
}