package com.memebattle.flexible_control.feature.auth.domain

import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.auth.data.AuthApi
import com.memebattle.flexible_control.feature.auth.domain.model.AuthRequest
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiAuthService(val authApi: AuthApi) {
    fun signIn(phone: String, password: String, callback: BaseCallback<AuthResponse>) {
        val req = AuthRequest(phone, password)
        authApi.signIn(req)
                .enqueue(object : Callback<AuthResponse> {
                    override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                        callback.onError(t)
                    }

                    override fun onResponse(call: Call<AuthResponse>, response: Response<AuthResponse>) {
                        callback.onSuccess(response.body()!!)
                    }
                })
    }
}