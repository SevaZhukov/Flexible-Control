package com.memebattle.flexible_control.feature.main.task_list.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import com.memebattle.flexible_control.R


class TaskListAdapter(val tasks: List<Task>): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        //TODO draw item
    }
}