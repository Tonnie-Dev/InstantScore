package com.uxstate.instantscore.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.uxstate.instantscore.data.local.entities.FixtureEntity

@Dao
interface ScoresDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(list: List<FixtureEntity>)

    @Query(
        """SELECT * FROM fixtures_table 
        WHERE dayOfMonth=:dayOfMonth AND month =:month AND year=:year"""
    )
    suspend fun getFixturesByDate(dayOfMonth: Int, month: Int, year: Int): List<FixtureEntity>

    @Query("DELETE FROM fixtures_table")
    suspend fun clearFixtures()
}