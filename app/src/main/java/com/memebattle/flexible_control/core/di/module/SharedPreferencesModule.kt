package com.memebattle.flexible_control.core.di.module

import android.content.Context
import android.content.SharedPreferences
import com.memebattle.flexible_control.core.domain.SettingsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule(var context: Context) {
    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun settingsService(sharedPreferences: SharedPreferences): SettingsService {
        return SettingsService(sharedPreferences)
    }
}