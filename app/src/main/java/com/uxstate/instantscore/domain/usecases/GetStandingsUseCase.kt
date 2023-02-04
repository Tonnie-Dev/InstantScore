package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.domain.models.standings.Standing
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

class GetStandingsUseCase(private val repository: ScoresRepository) {

    operator fun invoke(leagueId: Int): Flow<Resource<MutableList<Standing>>> {

        val season = LocalDate.now().year
        return repository.getStandings(leagueId = leagueId, season = season)
    }
}