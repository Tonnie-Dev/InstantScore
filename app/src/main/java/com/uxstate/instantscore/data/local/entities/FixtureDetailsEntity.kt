package com.uxstate.instantscore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.instantscore.domain.models.fixture_details.Event
import com.uxstate.instantscore.domain.models.fixture_details.Stats
import com.uxstate.instantscore.domain.models.fixtures_schedule.Team

@Entity(tableName = "fixture_details_table")
data class FixtureDetailsEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val fixtureId: Int,
    val date: Long,
    val venue: String,
    val status: String,
    val timeElapsed: Int,
    val teams: Pair<Team, Team>,
    val events: List<Event>,
    val stats: Stats
)
