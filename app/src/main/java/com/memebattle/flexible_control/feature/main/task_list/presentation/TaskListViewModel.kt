package com.memebattle.flexible_control.feature.main.task_list.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.main.task_list.domain.TaskListRepository
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task

class TaskListViewModel: ViewModel() {
    var tasks = MutableLiveData<List<Task>>()
    var errorMessage = MutableLiveData<String>()

    val repository = TaskListRepository()

    fun getTasks() {
        repository.getTasks(object : BaseCallback<List<Task>> {
            override fun onSuccess(result: List<Task>) {
                tasks.value = result
            }

            override fun onError(error: Throwable) {
                errorMessage.value = error.message
            }
        })
    }
}