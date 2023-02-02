package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetStandingsUseCase(private val repository: ScoresRepository) {

    operator fun invoke(leagueId: Int, season: Int): Flow<Resource<List<Standing>>> {

        return repository.getStandings(leagueId = leagueId, season = season)
    }
}