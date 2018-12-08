package com.memebattle.flexible_control


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.fragment_auth.view.*


class MainFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_main, container, false)

        v.button.setOnClickListener {
            navController.navigate(R.id.mainFragment)
        }
        return v
    }

}
