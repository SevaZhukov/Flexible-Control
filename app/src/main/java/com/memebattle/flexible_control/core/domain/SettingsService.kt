package com.memebattle.flexible_control.core.domain

import android.content.SharedPreferences

class SettingsService(private val sharedPreferences: SharedPreferences) {

    val ID = "_id"
    val ERROR = "error"

    fun setId(id: String) {
        val editor = sharedPreferences.edit()
        editor.putString(ID, id)
        editor.apply()
    }

    fun getId(): String {
        return sharedPreferences.getString(ID, ERROR)!!
    }
}