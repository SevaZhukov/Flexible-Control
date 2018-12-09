package com.memebattle.flexible_control.feature.report.presentation

import android.net.Uri
import androidx.lifecycle.ViewModel;
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.auth.domain.ApiAuthService
import com.memebattle.flexible_control.feature.auth.domain.model.AuthResponse
import com.memebattle.flexible_control.feature.report.domain.ApiReportService
import com.memebattle.flexible_control.feature.report.domain.model.ReportRequest
import okhttp3.ResponseBody
import javax.inject.Inject

class ReportViewModel : ViewModel() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiReportService
    fun upload(description1: String, description2: String, uri: Uri) {
        apiService.uploadFile(uri, ReportRequest(description1,description2), object : BaseCallback<ResponseBody>{
            override fun onSuccess(result: ResponseBody) {

            }
            override fun onError(error: Throwable) {

            }
        })
    }

}
