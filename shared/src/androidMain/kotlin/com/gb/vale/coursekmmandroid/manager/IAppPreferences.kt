package com.gb.vale.coursekmmandroid.manager

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : Boolean

}