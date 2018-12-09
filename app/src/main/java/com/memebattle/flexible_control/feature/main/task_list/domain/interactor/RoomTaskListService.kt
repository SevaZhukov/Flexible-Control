package com.memebattle.flexible_control.feature.main.task_list.domain.interactor

import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListDao
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RoomTaskListService(val dao: TaskListDao) {
    fun getTasks(callback: BaseCallback<List<Task>>) {
        dao.getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onSuccess(it) }, { callback.onError(it) })
    }

    fun addTasks(tasks: List<Task>) {
        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            dao.addTasks(tasks)
            subscriber.onComplete()
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ }, { })
    }

    fun deleteTasks() {
        Observable.create(ObservableOnSubscribe<String> { subscriber ->
            dao.deleteAll()
            subscriber.onComplete()

        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ }, { })
    }
}