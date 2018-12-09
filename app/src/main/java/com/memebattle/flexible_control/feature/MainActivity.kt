package com.memebattle.flexible_control.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.R
import com.memebattle.flexible_control.core.domain.SettingsService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController

    @Inject
    lateinit var settingsService: SettingsService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)
        navController = Navigation.findNavController(this, R.id.nav_host_global)
        if (settingsService.getId() != settingsService.ERROR)
            navController.navigate(R.id.action_authFragment_to_mainFragment)
        //TODO check auth and rout to auth or main
    }
}
