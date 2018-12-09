package com.memebattle.flexible_control.feature.main.task_list.domain

import android.util.Log
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.core.domain.SettingsService
import com.memebattle.flexible_control.feature.main.task_list.domain.interactor.ApiTaskListService
import com.memebattle.flexible_control.feature.main.task_list.domain.interactor.RoomTaskListService
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import com.memebattle.flexible_control.feature.main.task_list.domain.model.TaskList
import javax.inject.Inject

class TaskListRepository {

    @Inject
    lateinit var apiService: ApiTaskListService
    @Inject
    lateinit var roomService: RoomTaskListService
    @Inject
    lateinit var settingsService: SettingsService

    init {
        App.component.inject(this)
    }

    fun getTasks(callback: BaseCallback<List<Task>>) {
        roomService.getTasks(object : BaseCallback<List<Task>> {
            override fun onSuccess(result: List<Task>) {
                Log.i("code", "size ${result.size}")
                if (!result.isEmpty()) {
                    callback.onSuccess(result)
                }
                apiService.getTasks(object : BaseCallback<TaskList> {
                    override fun onSuccess(result: TaskList) {
                        Log.i("code", "size api ${result.data.size}")
                        callback.onSuccess(result.data)
                        roomService.deleteTasks()
                        roomService.addTasks(result.data)
                    }

                    override fun onError(error: Throwable) {
                        Log.i("code", "error ${error.message}")
                        callback.onError(error)
                    }
                })
            }

            override fun onError(error: Throwable) {
                callback.onError(error)
            }
        })
    }
}