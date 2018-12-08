package com.memebattle.flexible_control.core.di.module

import android.content.Context
import androidx.room.Room
import com.memebattle.flexible_control.core.data.AppDatabase
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListDao
import com.memebattle.flexible_control.feature.main.task_list.domain.interactor.RoomTaskListService
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

    @Provides
    @Singleton
    fun provideTaskListDao(appDatabase: AppDatabase): TaskListDao {
        return appDatabase.taskListDao()
    }

    @Provides
    @Singleton
    fun roomTaskListService(dao: TaskListDao): RoomTaskListService {
        return RoomTaskListService(dao)
    }
}