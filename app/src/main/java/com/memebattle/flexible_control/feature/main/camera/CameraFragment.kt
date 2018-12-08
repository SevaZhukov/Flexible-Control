package com.memebattle.flexible_control.feature.main.camera


import android.app.Activity.RESULT_OK
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.memebattle.flexible_control.R
import android.net.Uri
import android.os.Environment
import org.jetbrains.anko.design.snackbar
import java.io.File
import java.util.*


class CameraFragment : Fragment() {
    private val TAKE_PICTURE_REQUEST = 1
    private lateinit var outputFileUri: Uri
    private lateinit var rootView:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        takePhoto()
        rootView = inflater.inflate(R.layout.fragment_camera, container, false)
        return rootView

    }
    fun takePhoto(){

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file = File(Environment.getExternalStorageDirectory(),
                UUID.randomUUID().toString()+".png")
        outputFileUri = Uri.fromFile(file)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri)
        startActivityForResult(intent, TAKE_PICTURE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == RESULT_OK) {
            rootView.snackbar("Фотография загружена")
        }
    }
}