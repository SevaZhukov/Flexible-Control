package com.memebattle.flexible_control.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListDao

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskListDao(): TaskListDao
}