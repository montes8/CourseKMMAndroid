package com.gb.vale.coursekmmandroid.usecases

import com.gb.vale.coursekmmandroid.manager.PreferenceManager
import com.gb.vale.coursekmmandroid.repository.AppPreferences
import com.gb.vale.coursekmmandroid.utils.EMPTY


class AppUseCase(private val context: PreferenceManager) {
    private val iAppPreference : IAppPreferences = AppPreferences(context)
    fun saveToken(value : String) = iAppPreference.saveToken(value)
    fun getToken() = iAppPreference.getToken()

}