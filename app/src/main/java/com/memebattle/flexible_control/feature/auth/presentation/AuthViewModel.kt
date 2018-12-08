package com.memebattle.flexible_control.feature.auth.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.auth.domain.ApiAuthService
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import javax.inject.Inject

class AuthViewModel : ViewModel() {

    var user = MutableLiveData<AuthResponse>()
    var errorMessage = MutableLiveData<String>()

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiAuthService

    fun signIn(phone: String, password: String) {
        apiService.signIn(phone, password, object : BaseCallback<AuthResponse> {
            override fun onSuccess(result: AuthResponse) {
                user.value = result
            }

            override fun onError(error: Throwable) {
                errorMessage.value = error.message.toString()
            }
        })
    }
}