package com.software1t.selldesk.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.software1t.selldesk.local.model.CarLocalModel

@Database(entities = [CarLocalModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun carDao(): CarDao
}