package com.memebattle.flexible_control.core.di.module

import android.content.Context
import androidx.room.Room
import com.memebattle.flexible_control.core.data.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(val context: Context) {

    @Provides
    @Singleton
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "database").build()
    }
}