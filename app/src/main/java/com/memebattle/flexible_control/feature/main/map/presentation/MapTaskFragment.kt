package com.memebattle.flexible_control.feature.main.map.presentation


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.R
import com.memebattle.flexible_control.core.domain.BaseCallback
import com.memebattle.flexible_control.feature.report.domain.ApiWeatherService
import com.memebattle.flexible_control.feature.weather.domain.model.Location
import com.memebattle.flexible_control.feature.weather.domain.model.WeatherResponse
import javax.inject.Inject


class MapTaskFragment : Fragment() {
    private lateinit var viewModel: MapTaskViewModel
    private lateinit var v: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_map_task, container, false)
        return v
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MapTaskViewModel::class.java)
    }

}
