package com.memebattle.flexible_control.feature.main.task_list.domain.interactor

import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListDao
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import org.jetbrains.anko.custom.async
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class RoomTaskListService(val dao: TaskListDao) {
    fun getTasks(callback: BaseCallback<List<Task>>) {
        dao.getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onSuccess(it) }, { callback.onError(it) })
    }

    fun addTasks(tasks: List<Task>) {
        Observable.create(Observable.OnSubscribe<String> { subscriber ->
            dao.addTasks(tasks)
            subscriber.onCompleted()

        })
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe({ }, { })
    }

    fun deleteTasks() {
        Observable.create(Observable.OnSubscribe<String> { subscriber ->
            dao.deleteAll()
            subscriber.onCompleted()

        })
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe({ }, { })
    }
}