package com.memebattle.flexible_control.feature.report.domain
import android.net.Uri
import com.google.gson.Gson
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.report.data.ReportApi
import com.memebattle.flexible_control.feature.report.domain.model.ReportRequest
import com.memebattle.flexible_control.feature.weather.data.WeatherApi
import com.memebattle.flexible_control.feature.weather.domain.model.WeatherRequest
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody
import okhttp3.RequestBody
import okhttp3.MultipartBody
import java.io.File




class ApiWeatherService(val weatherApi: WeatherApi) {

    fun getWeather(baseCallback: BaseCallback<WeatherRequest>) {
        weatherApi.getWeather().enqueue(object :Callback<WeatherRequest>{
            override fun onFailure(call: Call<WeatherRequest>, t: Throwable) {
                baseCallback.onError(t)
            }
            override fun onResponse(call: Call<WeatherRequest>, response: Response<WeatherRequest>) {
                baseCallback.onSuccess(response.body()!!)
            }
        })
    }
}