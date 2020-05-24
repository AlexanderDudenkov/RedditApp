package com.dudencov.redditapp.di.modules

import android.app.Application
import androidx.room.Room
import com.dudencov.redditapp.data.local.db.AppDatabase
import com.dudencov.redditapp.di.scopes.ApplicationScope
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "RedditApp_database")
            .fallbackToDestructiveMigration().build()
    }
}