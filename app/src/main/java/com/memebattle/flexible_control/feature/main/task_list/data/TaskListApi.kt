package com.memebattle.flexible_control.feature.main.task_list.data

import com.memebattle.flexible_control.feature.main.task_list.domain.model.TaskList
import retrofit2.Call
import retrofit2.http.GET

interface TaskListApi {
    @GET("/")
    fun getTasks(): Call<TaskList>
}