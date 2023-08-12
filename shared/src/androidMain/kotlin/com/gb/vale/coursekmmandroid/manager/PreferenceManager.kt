package com.gb.vale.coursekmmandroid.manager

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


actual typealias PreferenceManager = Activity

actual fun PreferenceManager.getInt(key: String ) : Int{
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getInt(key, -1)
}


actual fun PreferenceManager.setInt(key: String, value: Int) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putInt(key,value)
    editor.apply()
}

actual fun PreferenceManager.getString(key: String ) : String{
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getString(key, "")?:""
}


actual fun PreferenceManager.setString(key: String, value: String) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString(key,value)
    editor.apply()
}

actual fun PreferenceManager.getBoolean(key: String ) : Boolean{
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getBoolean(key, false)
}


actual fun PreferenceManager.setBoolean(key: String, value: Boolean) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putBoolean(key,value)
    editor.apply()
}