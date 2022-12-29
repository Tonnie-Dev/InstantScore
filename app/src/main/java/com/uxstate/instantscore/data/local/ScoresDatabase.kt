package com.uxstate.instantscore.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.uxstate.instantscore.data.local.converters.Converters
import com.uxstate.instantscore.data.local.dao.ScoresDAO
import com.uxstate.instantscore.data.local.entities.FixtureEntity
import com.uxstate.instantscore.data.local.entities.FixtureFakeEntity

@Database(entities = [FixtureFakeEntity::class, FixtureEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class ScoresDatabase : RoomDatabase() {

    abstract val dao: ScoresDAO
}