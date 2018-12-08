package com.memebattle.flexible_control.feature.report.data

import com.memebattle.flexible_control.feature.auth.domain.model.AuthRequest
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import com.memebattle.flexible_control.feature.report.domain.model.ReportRequest
import com.memebattle.flexible_control.feature.report.domain.model.ReportResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.Multipart
import retrofit2.http.Part


interface ReportApi {
        @Multipart
        @POST("/")
        fun postImage(@Part image: MultipartBody.Part, @Part("json") json: RequestBody): Call<ResponseBody>
}