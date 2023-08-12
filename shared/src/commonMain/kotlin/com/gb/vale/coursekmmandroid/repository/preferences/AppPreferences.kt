package com.gb.vale.coursekmmandroid.repository.preferences

import com.gb.vale.coursekmmandroid.manager.PreferenceManager
import com.gb.vale.coursekmmandroid.manager.getString
import com.gb.vale.coursekmmandroid.manager.setString
import com.gb.vale.coursekmmandroid.usecases.repository.preference.IAppPreferences
import com.gb.vale.coursekmmandroid.utils.PREFERENCE_TOKEN


class AppPreferences(private val context: PreferenceManager):
    IAppPreferences {

    override fun saveToken(value : String ) = context.setString(PREFERENCE_TOKEN,value)

    override fun getToken() = context.getString(PREFERENCE_TOKEN).isNotEmpty()
}