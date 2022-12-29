package com.uxstate.instantscore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.instantscore.domain.models.fixtures_schedule.Goal
import com.uxstate.instantscore.domain.models.fixtures_schedule.League
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team

@Entity(tableName = "fixtures_table")
data class FixtureEntity(
    @PrimaryKey(autoGenerate = false)
    val fixtureId: Int,
    val status: Status,
    val league: League,
    val teams: Pair<Team, Team>,
    val goals: Goal,
    val dayOfMonth: Int,
    val month: Int,
    val year: Int
)
