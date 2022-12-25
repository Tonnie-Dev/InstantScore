package com.uxstate.instantscore.data.remote.mappers

import com.uxstate.instantscore.data.local.entities.FixtureEntity
import com.uxstate.instantscore.data.remote.dtos.fixtures.FixtureDTO
import com.uxstate.instantscore.domain.models.fixtures.Fixture
import com.uxstate.instantscore.domain.models.fixtures.Status

//FixtureEntity to Model - Setting a declaration as internal means that it’ll
// be available in the same module only.
internal fun FixtureEntity.toModel(): Fixture {

    return Fixture(
            fixtureId = this.fixtureId,
            date = this.date,
            status = this.status,
            teams = this.teams
    )
}

//FixturesResponseDTO to Entity
fun FixtureDTO.toEntity(): FixtureEntity {


    return FixtureEntity(
            fixtureId = this.id, date = this.timestamp.toLong(), status = Status(
            fixtureLong = this.status.long,
            fixtureShort = this.status.short,
            timeElapsed = this.status.elapsed ?: 0
    ), teams = Pair(first = )
    )
}