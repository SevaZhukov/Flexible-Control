package com.memebattle.flexible_control.core.domain

import android.Manifest
import android.location.LocationManager
import android.location.Location
import android.os.Bundle
import android.location.LocationListener
import android.content.pm.PackageManager
import androidx.core.content.getSystemService
import com.memebattle.flexible_control.App
import com.memebattle.flexible_control.feature.main.task_list.domain.model.LocationModel


class LocationService() {

    fun getAddress(callback: BaseCallback<LocationModel>) {
        val internetLocationListener = object : LocationListener {

            override fun onLocationChanged(location: Location) {
                callback.onSuccess(LocationModel(location.latitude,location.longitude))
            }

            override fun onProviderDisabled(provider: String) {

            }

            override fun onProviderEnabled(provider: String) {

            }

            override fun onStatusChanged(provider: String, status: Int, extras: Bundle) {

            }
        }
        if (checkPermission()) {
            App.instance.applicationContext.getSystemService<LocationManager>()?.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 3000, 10f, internetLocationListener)
        }

    }
    private fun checkPermission(): Boolean {
        val permissionGpsLocation = Manifest.permission.ACCESS_FINE_LOCATION
        val permissionInternetLocation = Manifest.permission.ACCESS_COARSE_LOCATION
        val permissionInternet = Manifest.permission.INTERNET
        val resInternet = App.instance.applicationContext.checkCallingOrSelfPermission(permissionInternet)
        val resGpsLocation = App.instance.applicationContext.checkCallingOrSelfPermission(permissionGpsLocation)
        val resInternetLocation = App.instance.applicationContext.checkCallingOrSelfPermission(permissionInternetLocation)
        return resGpsLocation == PackageManager.PERMISSION_GRANTED && resInternetLocation == PackageManager.PERMISSION_GRANTED && resInternet == PackageManager.PERMISSION_GRANTED
    }
}

