package com.memebattle.flexible_control.feature.main.camera


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.memebattle.flexible_control.R

class CameraFragment : Fragment() {
    private val CAMERA_REQUEST = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    fun takePhoto() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            Log.i("TAG", "${imageBitmap.byteCount}")
        }
    }

}
