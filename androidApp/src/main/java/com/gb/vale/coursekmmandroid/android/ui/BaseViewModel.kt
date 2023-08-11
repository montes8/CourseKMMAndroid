package com.gb.vale.coursekmmandroid.android.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {


    fun execute(loading: Boolean = true,func:suspend ()->Unit){
        viewModelScope.launch(Dispatchers.IO){
            try {
                func()
            }catch (ex:Throwable){
            }
        }
    }
}