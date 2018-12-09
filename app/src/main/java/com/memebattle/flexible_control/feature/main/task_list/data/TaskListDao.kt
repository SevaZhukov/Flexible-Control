package com.memebattle.flexible_control.feature.main.task_list.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import io.reactivex.Single

@Dao
interface TaskListDao {
    @Insert
    fun addTasks(tasks: List<Task>)

    @Delete
    fun deleteTasks(tasks: List<Task>)

    @Query("DELETE FROM task")
    fun deleteAll()

    @Query("SELECT * FROM task")
    fun getTasks(): Single<List<Task>>
}