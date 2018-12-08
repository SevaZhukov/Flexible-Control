package com.memebattle.flexible_control.feature.main.task_list.presentation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.memebattle.flexible_control.R
import org.jetbrains.anko.design.snackbar


class TaskListFragment : Fragment() {

    lateinit var viewModel: TaskListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tasks, container, false)
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)
        viewModel.tasks.observe(this, Observer {

        })
        viewModel.errorMessage.observe(this, Observer {
            v.snackbar(it)
        })
        viewModel.getTasks()
        return v
    }
}
