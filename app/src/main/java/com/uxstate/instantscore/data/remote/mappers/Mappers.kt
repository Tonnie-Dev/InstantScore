package com.uxstate.instantscore.data.remote.mappers

import com.uxstate.instantscore.data.local.entities.FixtureEntity
import com.uxstate.instantscore.domain.models.fixtures_details.FixtureBonoko
import com.uxstate.instantscore.domain.models.fixtures_schedule.*
import com.uxstate.instantscore.utils.toCustomLocalDate
import com.uxstate.instantscore.utils.toZonedDateTime
import java.time.LocalDate



// FixtureEntity to Model- Setting a declaration as internal means that it’ll
// be available in the same module only.
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
fun com.uxstate.instantscore.data.remote.dtos.fixtures_by_date.ResponseDTO.toEntity():
    FixtureEntity {

    return FixtureEntity(
        fixtureId = this.fixture.id,

        status = Status(
            fixtureLong = this.fixture.status.long,
            fixtureShort = this.fixture.status.short,
            timeElapsed = this.fixture.status.elapsed ?: -1
        ),
        league = League(
            id = this.league.id,
            name = this.league.name,
            country = this.league.country,
            leagueLogo = this.league.logo,
            countryFlag = this.league.flag ?: ""
        ),
        teams = Pair(
            Team(name = this.teams.home.name, logo = this.teams.home.logo),
            Team(name = this.teams.away.name, logo = this.teams.away.logo)
        ),

        goals = Goal(
            homeTeamScore = this.goals.home ?: -1,
            awayTeamScore = this.goals.away ?: -1
        ),
        dayOfMonth = this.fixture.timestamp.toZonedDateTime()
            .toCustomLocalDate().dayOfMonth,
        month = this.fixture.timestamp.toZonedDateTime()
            .toCustomLocalDate().monthValue,
        year = this.fixture.timestamp.toZonedDateTime()
            .toCustomLocalDate().year
    )
}
