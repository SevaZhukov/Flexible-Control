package com.memebattle.flexible_control.feature.auth.presentation


import android.hardware.Camera
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.flexible_control.R
import kotlinx.android.synthetic.main.fragment_auth.view.*
import org.jetbrains.anko.design.snackbar

class AuthFragment : Fragment() {

    lateinit var viewModel: AuthViewModel

    lateinit var navController: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_auth, container, false)
        viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        navController = Navigation.findNavController(activity!!, R.id.nav_host_global)

        v.authButton.setOnClickListener {
            //viewModel.signIn("+79529097158", "qwqweqw")
            viewModel.signIn(v.phone.text.toString(), v.password.text.toString())
        }
        viewModel.user.observe(this, Observer {
            navController.navigate(R.id.action_authFragment_to_mainFragment)
        })
        viewModel.errorMessage.observe(this, Observer {
            v.rootView.snackbar(it)
        })
        return v
    }
}
