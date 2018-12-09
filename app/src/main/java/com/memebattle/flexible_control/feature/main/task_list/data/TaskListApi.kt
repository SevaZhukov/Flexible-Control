package com.memebattle.flexible_control.feature.main.task_list.data

import com.memebattle.flexible_control.feature.main.task_list.domain.model.TaskList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TaskListApi {
    @GET("/tasks/{id}")
    fun getTasks(@Path("id") id: String): Call<TaskList>
}