package com.gb.vale.coursekmmandroid.android.application

import android.app.Application
import com.gb.vale.coursekmmandroid.manager.db.appContext
import com.gb.vale.coursekmmandroid.usecases.UseUseCase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class KmmApplication  : Application()