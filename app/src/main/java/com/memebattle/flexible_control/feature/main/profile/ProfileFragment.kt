package com.memebattle.flexible_control.feature.main.profile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.memebattle.flexible_control.R
import kotlinx.android.synthetic.main.fragment_profile.*
import android.graphics.Paint
import kotlinx.android.synthetic.main.fragment_profile.view.*


class ProfileFragment : Fragment() {
    lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_profile, container, false)
        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        v.textView9.paintFlags = textView9.paintFlags or Paint.UNDERLINE_TEXT_FLAG

    }
}
