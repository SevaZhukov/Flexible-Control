package com.memebattle.flexible_control.feature.main.task_list.presentation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.memebattle.flexible_control.R
import com.memebattle.flexible_control.feature.main.task_list.presentation.recycler.TaskListAdapter
import kotlinx.android.synthetic.main.fragment_tasks.view.*
import org.jetbrains.anko.design.snackbar


class TaskListFragment : Fragment() {

    lateinit var viewModel: TaskListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_tasks, container, false)
        viewModel = ViewModelProviders.of(this).get(TaskListViewModel::class.java)
        v.recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity!!)
        viewModel.tasks.observe(this, Observer {
            v.recycler.adapter = TaskListAdapter(it, Navigation.findNavController(activity!!, R.id.nav_host_global))
        })
        viewModel.errorMessage.observe(this, Observer {
            Log.i("code", it)
            v.rootView.snackbar(it)
        })
        viewModel.getTasks()
        return v
    }
}
