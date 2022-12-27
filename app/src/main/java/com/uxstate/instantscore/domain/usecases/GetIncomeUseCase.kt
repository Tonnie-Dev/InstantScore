package com.uxstate.instantscore.domain.usecases

import com.uxstate.instantscore.data.remote.dtos.stackoverflow.NetworkIncome
import com.uxstate.instantscore.domain.repository.ScoresRepository
import com.uxstate.instantscore.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetIncomeUseCase(private val repository: ScoresRepository) {

    operator fun invoke(): Flow<Resource<List<NetworkIncome>>> {

        return repository.getIncome()
    }
}