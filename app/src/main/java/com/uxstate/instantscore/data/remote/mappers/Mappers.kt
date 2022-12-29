package com.uxstate.instantscore.data.remote.mappers

import com.uxstate.instantscore.data.local.entities.FixtureFakeEntity
import com.uxstate.instantscore.data.remote.dtos.fixtures.ResponseDTO
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team

// FixtureEntity to Model - Setting a declaration as internal means that it’ll
// be available in the same module only.
internal fun FixtureFakeEntity.toModel(): FixtureBonoko {

    return FixtureBonoko(
        fixtureId = this.fixtureId,
        date = this.date,
        status = this.status,
        teams = this.teams
    )
}

// FixturesResponseDTO to Entity
fun ResponseDTO.toEntity(): FixtureFakeEntity {

    return FixtureFakeEntity(
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