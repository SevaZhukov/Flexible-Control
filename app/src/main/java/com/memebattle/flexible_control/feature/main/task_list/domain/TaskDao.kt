package com.memebattle.flexible_control.feature.main.task_list.domain

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert
    fun addTasks(tasks: List<Task>)

    @Delete
    fun deleteTasks(tasks: List<Task>)

    @Query("DELETE FROM task")
    fun deleteAll()

    @Query("SELECT * FROM task")
    fun getTasks(): List<Task>
}