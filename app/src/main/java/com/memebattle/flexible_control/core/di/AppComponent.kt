package com.memebattle.flexible_control.core.di

import com.memebattle.flexible_control.core.di.module.ApiModule
import com.memebattle.flexible_control.core.di.module.RoomModule
import com.memebattle.flexible_control.core.di.module.SharedPreferencesModule
import com.memebattle.flexible_control.feature.MainActivity
import com.memebattle.flexible_control.feature.auth.presentation.AuthViewModel
import com.memebattle.flexible_control.feature.main.map.presentation.MapTaskFragment
import com.memebattle.flexible_control.feature.main.task_list.domain.TaskListRepository
import com.memebattle.flexible_control.feature.report.presentation.ReportViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RoomModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun inject(authViewModel: AuthViewModel)
    fun inject(authViewModel: TaskListRepository)
    fun inject(reportViewModel: ReportViewModel)
    fun inject(mainActivity: MainActivity)
    fun inject(mapTaskFragment: MapTaskFragment)
}