package com.memebattle.flexible_control.feature.weather.data

import com.memebattle.flexible_control.feature.weather.domain.model.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET


interface WeatherApi {
        @GET("https://weather.api.here.com/weather/1.0/report.json?app_id=XMZ66PcCJqcKaYV5TQAu&app_code=xPdfiEpA7yKr_tDpWbzJjw&product=observation&name=moscow")
        fun getWeather(): Call<WeatherResponse>
}