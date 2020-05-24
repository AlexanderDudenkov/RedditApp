package com.dudencov.redditapp.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dudencov.redditapp.data.local.db.AppDatabase.Companion.VERSION
import com.dudencov.redditapp.data.local.db.dao.TopListDao
import com.dudencov.redditapp.data.local.db.tables.TopListTable

@Database(entities = [TopListTable::class], version = VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getTopListDao(): TopListDao

    companion object {
        const val VERSION = 1
    }
}