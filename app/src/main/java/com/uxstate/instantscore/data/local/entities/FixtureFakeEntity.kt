package com.uxstate.instantscore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.instantscore.domain.models.fixtures_schedule.Status
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team

@Entity(tableName = "fixture_table")
data class FixtureFakeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val teams: Pair<Team, Team>
)
