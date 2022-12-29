package com.uxstate.instantscore.data.remote.mappers

import com.uxstate.instantscore.data.local.entities.FixtureEntity
import com.uxstate.instantscore.data.local.entities.FixtureFakeEntity
import com.uxstate.instantscore.data.remote.dtos.fixtures.ResponseDTO
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.Fixture
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team
import java.time.LocalDate

// FixtureEntity to Model - Setting a declaration as internal means that it’ll
// be available in the same module only.
internal fun FixtureFakeEntity.toModel(): FixtureBonoko {

    return FixtureBonoko(
            fixtureId = this.fixtureId, date = this.date, status = this.status, teams = this.teams
    )
}

//FixtureEntity to Model
internal fun FixtureEntity.toModel(): Fixture {

    return Fixture(
            fixtureId = this.fixtureId,
            date = LocalDate.of(this.year, this.month, this.dayOfMonth),
            status = Status(
                    fixtureLong = this.status.fixtureLong,
                    fixtureShort = this.status.fixtureShort,
                    timeElapsed = this.status.timeElapsed
            ),
            league = League(
                    id = this.league.id,
                    name = this.league.name,
                    country = this.league.country,
                    leagueLogo = this.league.leagueLogo,
                    countryFlag = this.league.countryFlag
            ),
            teams = Pair(this.teams.first, this.teams.second),
            goals = this.goals
    )
}

// FixturesResponseDTO to Entity
fun ResponseDTO.toEntity(): FixtureFakeEntity {

    return FixtureFakeEntity(
            fixtureId = this.fixture.id, date = this.fixture.timestamp.toLong(), status = Status(
            fixtureLong = this.fixture.status.long,
            fixtureShort = this.fixture.status.short,
            timeElapsed = this.fixture.status.elapsed ?: -1
    ), teams = Pair(
            first = (Team(
                    name = this.teams.home.name,
                    logo = this.teams.home.logo,
                    goalScored = this.goals.home ?: -1
            )), second = Team(
            name = this.teams.away.name,
            logo = this.teams.away.logo,
            goalScored = this.goals.away ?: -1
    )
    )
    )
}