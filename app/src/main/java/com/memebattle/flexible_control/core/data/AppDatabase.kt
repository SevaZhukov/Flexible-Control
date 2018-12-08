package com.memebattle.flexible_control.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memebattle.flexible_control.feature.main.task_list.domain.Task
import com.memebattle.flexible_control.feature.main.task_list.domain.TaskDao

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}