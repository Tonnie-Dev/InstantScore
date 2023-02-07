package com.uxstate.instantscore.di

import com.uxstate.instantscore.data.remote.json.FixtureDetailsJsonParser
import com.uxstate.instantscore.data.remote.json.JsonStringParser
import com.uxstate.instantscore.data.remote.json.LiveFixturesJsonParser
import com.uxstate.instantscore.data.remote.json.StandingsJsonParser
import com.uxstate.instantscore.domain.models.fixture_details.FixtureDetails
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.standings.Standing
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
    abstract fun bindJsonFixtureDetailsParser(
        fixtureDetailsJsonParser: FixtureDetailsJsonParser
    ): JsonStringParser<FixtureDetails>

    @Binds
    @Singleton
    abstract fun bindJsonStandingsParser(
        standingsJsonParser: StandingsJsonParser
    ): JsonStringParser<MutableList<Standing>>


    @Binds
    @Singleton
    abstract fun bindLiveFixturesJsonParser(
        liveFixturesJsonParser: LiveFixturesJsonParser
    ): JsonStringParser<MutableList<Fixture>>
}