package com.memebattle.flexible_control.feature.report.presentation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.FileProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.report_fragment.view.*
import org.jetbrains.anko.design.snackbar
import java.io.File
import java.util.*
import com.memebattle.flexible_control.R
import java.io.IOException
import java.text.SimpleDateFormat


class ReportFragment : Fragment() {

    private lateinit var viewModel: ReportViewModel
    private val TAKE_PICTURE_REQUEST = 0
    private lateinit var outputFileUri: Uri
    private lateinit var v:View

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.report_fragment, container, false)
        val activity = activity
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        viewModel = ViewModelProviders.of(this).get(ReportViewModel::class.java)
        v.addMainImage.setOnClickListener {
            v.imageView1.visibility=View.GONE
            //takePhoto()
            dispatchTakePictureIntent()
        }
        v.report.setOnClickListener {
            viewModel.upload("seva ne sharit", "voobshe",photoURI)
            navController.popBackStack()
        }
        return  v
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
        if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
            Log.i("code", photoURI.toString())
            //v.imageView.setImageURI(photoURI)
            Glide.with(context!!).load(photoURI).into(v.imageView)
            v.snackbar("Фотография загружена")
        }
        Log.i("code", "res $resultCode")
    }

    lateinit var mCurrentPhotoPath: String

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = activity!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }


    val REQUEST_TAKE_PHOTO = 1

    lateinit var photoURI: Uri

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(activity!!.packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    // Error occurred while creating the File
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    photoURI = FileProvider.getUriForFile(
                            activity!!,
                            "com.example.android.fileprovider",
                            it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }
}
