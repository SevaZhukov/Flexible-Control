package com.memebattle.flexible_control.feature.report.domain
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.weather.data.WeatherApi
import com.memebattle.flexible_control.feature.weather.domain.model.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiWeatherService(val weatherApi: WeatherApi) {

    fun getWeather(baseCallback: BaseCallback<WeatherResponse>) {
        weatherApi.getWeather().enqueue(object :Callback<WeatherResponse>{
            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                baseCallback.onError(t)
            }
            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                baseCallback.onSuccess(response.body()!!)
            }
        })
    }
}