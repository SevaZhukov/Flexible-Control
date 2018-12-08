package com.memebattle.flexible_control.feature.auth.data

import com.memebattle.flexible_control.feature.auth.domain.model.AuthRequest
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthApi {
    @POST("/")
    fun signIn(@Body req: AuthRequest): Call<AuthResponse>
}