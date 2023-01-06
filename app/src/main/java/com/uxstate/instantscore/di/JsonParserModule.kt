package com.uxstate.instantscore.di

import com.uxstate.instantscore.data.json.FixtureDetailsJsonParser
import com.uxstate.instantscore.data.json.JsonStringParser
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// We create a separate module to bind the interface to its implementation
@Module
@InstallIn(SingletonComponent::class)

abstract class JsonParserModule {

    /*The abstract function takes only a single parameter which
    is the interface implementation and the return type is the
    interface implemented by the given parameter object.*/

    @Binds
    @Singleton
    abstract fun bindJsonStringParser(
        fixtureDetailsJsonParser: FixtureDetailsJsonParser
    ): JsonStringParser<FixtureDetails>
}