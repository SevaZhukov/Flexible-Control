package com.memebattle.flexible_control.feature.main.task_list.presentation.recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.feature.main.task_list.domain.model.Task
import com.memebattle.flexible_control.R
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.report.domain.ApiWeatherService
import com.memebattle.flexible_control.feature.weather.domain.model.WeatherResponse
import kotlinx.android.synthetic.main.item_task.view.*
import javax.inject.Inject


class TaskListAdapter(val tasks: List<Task>, val navController: NavController): RecyclerView.Adapter<TaskViewHolder>() {
    init {
        App.component.inject(this)
    }
    @Inject
    lateinit var apiWeatherService: ApiWeatherService
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
        val itemview = holder.itemView
        itemview.title.text = task.name
        itemview.text.text = task.description
        apiWeatherService.getWeather(object : BaseCallback<WeatherResponse>{
            override fun onError(error: Throwable) {

            }

            override fun onSuccess(result: WeatherResponse) {
                itemview.imageView3.setImageResource(R.drawable.walk)
            }
        })
        itemview.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("id", task._id)
            navController.navigate(R.id.reportFragment, bundle)
        }
    }
}