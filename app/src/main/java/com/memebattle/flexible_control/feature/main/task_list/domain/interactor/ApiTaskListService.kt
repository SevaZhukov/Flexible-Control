package com.memebattle.flexible_control.feature.main.task_list.domain.interactor

import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.auth.data.AuthApi
import com.memebattle.flexible_control.feature.auth.domain.model.AuthRequest
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListApi
import com.memebattle.flexible_control.feature.main.task_list.domain.model.TaskList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiTaskListService(val taskListApi: TaskListApi) {
    fun getTasks(callback: BaseCallback<TaskList>) {
        taskListApi.getTasks("")
                .enqueue(object : Callback<TaskList> {
                    override fun onFailure(call: Call<TaskList>, t: Throwable) {
                        callback.onError(t)
                    }

                    override fun onResponse(call: Call<TaskList>, response: Response<TaskList>) {
                        if (response.body() != null)
                            callback.onSuccess(response.body()!!)
                    }
                })
    }
}