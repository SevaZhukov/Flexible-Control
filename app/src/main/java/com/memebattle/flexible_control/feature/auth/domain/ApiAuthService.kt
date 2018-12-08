package com.memebattle.flexible_control.feature.auth.domain

import com.memebattle.flexible_control.feature.auth.data.AuthApi
import com.memebattle.flexible_control.feature.auth.domain.model.AuthRequest

class ApiAuthService(val authApi: AuthApi) {
    fun signIn(phone: String, password: String) {
        val req = AuthRequest(phone, password)
        authApi.signIn(req)
    }
}