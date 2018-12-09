package com.memebattle.flexible_control.feature.main.task_list.data

import com.memebattle.flexible_control.feature.main.task_list.domain.model.TaskList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TaskListApi {
    @GET("/tasks")
    fun getTasks(@Query("lat") lat: Double, @Query("lng") lng: Double ): Call<TaskList>
}