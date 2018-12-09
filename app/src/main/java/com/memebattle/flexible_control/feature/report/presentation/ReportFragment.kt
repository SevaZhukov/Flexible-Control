package com.memebattle.flexible_control.feature.report.presentation

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.report_fragment.view.*
import org.jetbrains.anko.design.snackbar
import java.io.File
import java.util.*
import com.memebattle.flexible_control.R




class ReportFragment : Fragment() {

    private lateinit var viewModel: ReportViewModel
    private val TAKE_PICTURE_REQUEST = 0
    private lateinit var outputFileUri: Uri
    private lateinit var v:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.report_fragment, container, false)
        v.addMainImage.setOnClickListener {
            v.imageView1.visibility=View.GONE
            takePhoto()
        }
        v.button2.setOnClickListener {
            viewModel.upload("seva ne sharit", "voobshe",outputFileUri)
        }
        return  v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ReportViewModel::class.java)
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
        if (requestCode == TAKE_PICTURE_REQUEST && resultCode == Activity.RESULT_OK) {
            v.imageView.setImageURI(outputFileUri)
            v.snackbar("Фотография загружена")
        }
    }

}
