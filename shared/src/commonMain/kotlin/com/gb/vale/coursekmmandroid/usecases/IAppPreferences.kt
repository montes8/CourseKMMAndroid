package com.gb.vale.coursekmmandroid.usecases

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : Boolean

}