package com.memebattle.flexible_control.feature.main.task_list.domain

import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.core.domain.BaseCallback
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

    init {
        App.component.inject(this)
    }

    fun getTasks(callback: BaseCallback<List<Task>>) {
        roomService.getTasks(object : BaseCallback<List<Task>> {
            override fun onSuccess(result: List<Task>) {
                if (result.isEmpty()) {
                    apiService.getTasks(object : BaseCallback<TaskList> {
                        override fun onSuccess(result: TaskList) {
                            callback.onSuccess(result.data)
                            roomService.deleteTasks()
                            roomService.addTasks(result.data)
                        }

                        override fun onError(error: Throwable) {
                            callback.onError(error)
                        }
                    })
                } else {
                    callback.onSuccess(result)
                }
            }

            override fun onError(error: Throwable) {
                callback.onError(error)
            }
        })
    }
}