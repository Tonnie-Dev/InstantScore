package com.uxstate.instantscore.domain.usecases

data class UseCaseContainer(
    val getFixturesUseCase: GetFixturesUseCase,
    val getFixturesByDateUseCase: GetFixturesByDateUseCase
)