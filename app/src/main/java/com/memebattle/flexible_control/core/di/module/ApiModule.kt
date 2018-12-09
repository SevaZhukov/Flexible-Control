package com.memebattle.flexible_control.core.di.module

import com.memebattle.flexible_control.feature.auth.data.AuthApi
import com.memebattle.flexible_control.feature.auth.domain.ApiAuthService
import com.memebattle.flexible_control.feature.main.task_list.data.TaskListApi
import com.memebattle.flexible_control.feature.main.task_list.domain.interactor.ApiTaskListService
import com.memebattle.flexible_control.feature.report.data.ReportApi
import com.memebattle.flexible_control.feature.report.domain.ApiReportService
import com.memebattle.flexible_control.feature.report.domain.ApiWeatherService
import com.memebattle.flexible_control.feature.weather.data.WeatherApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://c7a0cf76.ngrok.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): ApiAuthService {
        val authApi = retrofit.create(AuthApi::class.java)
        return ApiAuthService(authApi)
    }

    @Provides
    @Singleton


    fun providesTaskListService(retrofit: Retrofit): ApiTaskListService {
        val authApi = retrofit.create(TaskListApi::class.java)
        return ApiTaskListService(authApi)
    }

    @Provides
    @Singleton
    fun providesReportService(retrofit: Retrofit): ApiReportService {
        val reportApi = retrofit.create(ReportApi::class.java)
        return ApiReportService(reportApi)
    }
    @Provides
    @Singleton
    fun providesWeatherService(retrofit: Retrofit): ApiWeatherService {
        val weatherApi = retrofit.create(WeatherApi::class.java)
        return ApiWeatherService(weatherApi)
    }
}