package com.gb.vale.coursekmmandroid.android.ui.init

sealed class InitUiEvent {
    class NavigateToNext(var value : Boolean) : InitUiEvent()

    class NavigateToHome(var success : Boolean)  : InitUiEvent()

    object NavigateToSuccess : InitUiEvent()
    object NavigateToRegister : InitUiEvent()
}