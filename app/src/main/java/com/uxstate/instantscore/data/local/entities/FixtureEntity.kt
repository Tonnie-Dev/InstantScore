package com.uxstate.instantscore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.instantscore.domain.models.fixtures.Status
import com.uxstate.instantscore.domain.models.fixtures.Team

@Entity(tableName = "fixture_table")
data class FixtureEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fixtureId: Int,
    val date: Long,
    val status: Status,
    val teams: Pair<Team, Team>
)
