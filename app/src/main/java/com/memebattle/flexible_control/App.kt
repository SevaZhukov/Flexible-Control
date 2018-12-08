package com.memebattle.flexible_control

import android.app.Application
import com.memebattle.flexible_control.core.di.AppComponent
import com.memebattle.flexible_control.core.di.DaggerAppComponent

class App : Application() {
    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .build()
    }
}