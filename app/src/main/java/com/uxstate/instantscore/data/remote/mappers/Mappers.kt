package com.uxstate.instantscore.data.remote.mappers

import com.uxstate.instantscore.data.local.entities.FixtureEntity
import com.uxstate.instantscore.data.remote.dtos.fixtures.ResponseDTO
import com.uxstate.instantscore.domain.models.fixtures.Fixture
import com.uxstate.instantscore.domain.models.fixtures.Status
import com.uxstate.instantscore.domain.models.fixtures.Team

// FixtureEntity to Model - Setting a declaration as internal means that it’ll
// be available in the same module only.
internal fun FixtureEntity.toModel(): Fixture {

    return Fixture(
        fixtureId = this.fixtureId,
        date = this.date,
        status = this.status,
        teams = this.teams
    )
}

// FixturesResponseDTO to Entity
fun ResponseDTO.toEntity(): FixtureEntity {

    return FixtureEntity(
        fixtureId = this.fixture.id,
        date = this.fixture.timestamp.toLong(),
        status = Status(
            fixtureLong = this.fixture.status.long,
            fixtureShort = this.fixture.status.short,
            timeElapsed = this.fixture.status.elapsed ?: -1
        ),
        teams = Pair(
            first = (
                Team(
                    name = this.teams.home.name,
                    logo = this.teams.home.logo,
                    goalScored = this.goals.home ?: -1
                )
                ),
            second = Team(
                name = this.teams.away.name,
                logo = this.teams.away.logo,
                goalScored = this.goals.away ?: -1
            )
        )
    )
}