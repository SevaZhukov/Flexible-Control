package com.memebattle.flexible_control.feature

import android.os.Bundle
import android.provider.MediaStore
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.here.android.mpa.common.GeoCoordinate
import com.here.android.mpa.common.OnEngineInitListener
import com.memebattle.flexible_control.R
import com.here.android.mpa.mapping.*
import com.here.android.mpa.mapping.Map




class MapActivity : AppCompatActivity() {
    private lateinit var viewModel: MapViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        viewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        val mapFragment = fragmentManager.findFragmentById(R.id.mapfragment) as MapFragment
        mapFragment.init { error ->
            if (error == OnEngineInitListener.Error.NONE) {
                val map = mapFragment.map
                val myImage = com.here.android.mpa.common.Image()
                myImage.setImageResource(R.drawable.aaaaaaaaaa)
                val mapMarker1 = MapMarker(GeoCoordinate(55.7627, 37.6057, 10.0), myImage)
                val mapMarker2 = MapMarker(GeoCoordinate(55.7648, 37.6059, 10.0), myImage)
                val mapMarker3 = MapMarker(GeoCoordinate(55.7629, 37.6034, 10.0), myImage)
                val mapMarker4 = MapMarker(GeoCoordinate(55.7650, 37.6023, 10.0), myImage)
                val mapMarker5 = MapMarker(GeoCoordinate(55.7653, 37.6095, 10.0), myImage)
                map.addMapObject(mapMarker1)
                map.addMapObject(mapMarker2)
                map.addMapObject(mapMarker3)
                map.addMapObject(mapMarker4)
                map.addMapObject(mapMarker5)
                map.setCenter(GeoCoordinate(55.7617,
                        37.6067), Map.Animation.LINEAR)
            } else {

            }
        }
    }
}