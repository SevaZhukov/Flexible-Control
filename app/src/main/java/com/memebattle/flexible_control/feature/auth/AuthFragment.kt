package com.memebattle.flexible_control.feature.auth


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.flexible_control.R
import kotlinx.android.synthetic.main.fragment_auth.view.*

class AuthFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_auth, container, false)
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)
        v.button.setOnClickListener {
            navController.navigate(R.id.action_authFragment_to_mainFragment)
        }
        return v
    }
}
