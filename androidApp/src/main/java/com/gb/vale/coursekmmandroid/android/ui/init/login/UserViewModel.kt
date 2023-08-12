package com.gb.vale.coursekmmandroid.android.ui.init.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gb.vale.coursekmmandroid.android.ui.BaseViewModel
import com.gb.vale.coursekmmandroid.android.ui.init.InitUiEvent
import com.gb.vale.coursekmmandroid.usecases.UseUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class UserViewModel: BaseViewModel()  {

    private val _eventFlow = MutableSharedFlow<InitUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    var uiToast by mutableStateOf(false)
    var uiToastRegister by mutableStateOf(false)

    private val useUseCase: UseUseCase = UseUseCase()

    fun login(user :String , pass : String){
        execute {
            val response = useUseCase.login(user,pass)
            uiToast = response==null
            _eventFlow.emit(InitUiEvent.NavigateToHome(response!=null))
        }
    }

    fun register(user :String , pass : String){
        execute {
            val response = useUseCase.register(user,pass,"hgfdsfgfdfd")
            if (response){
                uiToastRegister = true
                _eventFlow.emit(InitUiEvent.NavigateToSuccess)
            }
        }
    }

    fun nextRegister(){
        execute {
            _eventFlow.emit(InitUiEvent.NavigateToRegister)
        }
    }

}