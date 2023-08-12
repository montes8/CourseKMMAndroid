package com.gb.vale.coursekmmandroid.usecases.repository.preference

interface IAppPreferences {
    fun saveToken(value : String )

    fun getToken() : Boolean

}