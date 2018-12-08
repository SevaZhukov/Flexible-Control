package com.memebattle.flexible_control.feature.report.domain
import android.net.Uri
import com.google.gson.Gson
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.report.data.ReportApi
import com.memebattle.flexible_control.feature.report.domain.model.ReportRequest
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import okhttp3.ResponseBody
import okhttp3.RequestBody
import okhttp3.MultipartBody
import java.io.File




class ApiReportService(val reportApi: ReportApi) {
        fun uploadFile(fileUri: Uri, request: ReportRequest, callback: BaseCallback<ResponseBody>) {
        val file = File(fileUri.path)
        val reqFile = RequestBody.create(MediaType.parse("image/*"), file)
        val body = MultipartBody.Part.createFormData("upload", file.name, reqFile)
            val json = Gson().toJson(request)
            reportApi.postImage(body, RequestBody.create(MediaType.parse("multipart/form-data"), json)).enqueue(object: Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                callback.onError(t)
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                callback.onSuccess(response.body()!!)
            }
        })
    }
}