package com.gb.vale.coursekmmandroid.usecases

import com.gb.vale.coursekmmandroid.manager.PreferenceManager
import com.gb.vale.coursekmmandroid.repository.preferences.AppPreferences
import com.gb.vale.coursekmmandroid.usecases.repository.preference.IAppPreferences


class AppUseCase(private val context: PreferenceManager) {
    private val iAppPreference : IAppPreferences = AppPreferences(context)
    fun saveToken(value : String) = iAppPreference.saveToken(value)
    fun getToken() = iAppPreference.getToken()

}