package com.memebattle.flexible_control.feature.camera

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.memebattle.flexible_control.R
import android.content.Intent
import android.provider.MediaStore
import android.graphics.Bitmap
import android.app.Activity.RESULT_OK
import android.util.Log
import android.widget.ImageView


class CameraFragment : Fragment() {

    private lateinit var viewModel: CameraViewModel
    private lateinit var imageView: ImageView


    private val CAMERA_REQUEST = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.camera_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CameraViewModel::class.java)
        // TODO: Use the ViewModel
    }
    fun takePhoto(){
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(cameraIntent, CAMERA_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            // Фотка сделана, извлекаем картинку
            val imageBitmap = data!!.extras!!.get("data") as Bitmap
            Log.i("TAG","${imageBitmap.byteCount}")
        }
    }
}
