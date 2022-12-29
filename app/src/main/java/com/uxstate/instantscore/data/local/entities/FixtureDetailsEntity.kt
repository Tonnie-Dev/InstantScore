package com.uxstate.instantscore.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.uxstate.instantscore.data.remote.dtos.top_scorers.Team
import com.uxstate.instantscore.domain.models.fixtures_details.Event
import com.uxstate.instantscore.domain.models.fixtures_details.Stats

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
