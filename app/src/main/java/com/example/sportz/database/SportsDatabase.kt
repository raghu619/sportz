package com.example.sportz.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = [PlayerData::class], version = 1, exportSchema = false)
abstract class SportsDatabase : RoomDatabase() {

    abstract val sportsdatabaseDao: SportDatabaseDao

}

private lateinit var INSTANCE: SportsDatabase

fun getDatabase(context: Context): SportsDatabase {
    synchronized(SportDatabaseDao::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                SportsDatabase::class.java,
                "sports"
            ).build()
        }
    }
    return INSTANCE
}

