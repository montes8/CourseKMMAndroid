package com.gb.vale.coursekmmandroid.android.ui.init.splash

import android.app.Activity
import com.gb.vale.coursekmmandroid.android.ui.BaseViewModel
import com.gb.vale.coursekmmandroid.android.ui.init.InitUiEvent
import com.gb.vale.coursekmmandroid.usecases.AppUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class SplashViewModel(context : Activity): BaseViewModel()  {

    private val _eventFlow = MutableSharedFlow<InitUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    val appUseCase = AppUseCase(context)

    fun loadValidateLogin(){
        execute {
            val response = appUseCase.getToken()
            delay(3000)
            _eventFlow.emit(InitUiEvent.NavigateToNext(response))
        }
    }

    fun saveToken(){
        execute {
            appUseCase.saveToken("gfergfre")
        }
    }
}