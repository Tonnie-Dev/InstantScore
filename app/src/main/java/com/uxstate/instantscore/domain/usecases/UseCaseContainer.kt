package com.uxstate.instantscore.domain.usecases

data class UseCaseContainer(
    val getFixturesByDateUseCase: GetFixturesByDateUseCase,
    val getFixtureDetailsUseCase: GetFixtureDetailsUseCase,
    val getStandingsUseCase: GetStandingsUseCase,
    val getLiveFixturesUseCase: GetLiveFixturesUseCase
)