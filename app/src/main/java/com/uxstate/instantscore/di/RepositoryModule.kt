package com.uxstate.instantscore.di

import com.uxstate.instantscore.data.repository.ScoresRepositoryImpl
import com.uxstate.instantscore.domain.repository.ScoresRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindScoresRepository(repositoryImpl: ScoresRepositoryImpl):ScoresRepository
}