package com.memebattle.flexible_control.core.di

import com.memebattle.flexible_control.core.di.module.ApiModule
import com.memebattle.flexible_control.core.di.module.RoomModule
import com.memebattle.flexible_control.core.di.module.SharedPreferencesModule
import com.memebattle.flexible_control.feature.auth.presentation.AuthViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, RoomModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun inject(authViewModel: AuthViewModel)

}