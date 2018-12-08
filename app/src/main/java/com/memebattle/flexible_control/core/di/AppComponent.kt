package com.memebattle.flexible_control.core.di

import com.memebattle.flexible_control.core.di.module.ApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class])
interface AppComponent {

}