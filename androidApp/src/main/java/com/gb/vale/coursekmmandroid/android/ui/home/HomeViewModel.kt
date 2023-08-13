package com.gb.vale.coursekmmandroid.android.ui.home

import android.app.Activity
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gb.vale.coursekmmandroid.android.ui.BaseViewModel
import com.gb.vale.coursekmmandroid.entity.RecipeModel
import com.gb.vale.coursekmmandroid.usecases.AppUseCase
import com.gb.vale.coursekmmandroid.usecases.DataUseCase

class HomeViewModel(context : Activity): BaseViewModel() {

    var uiStateListRecipes by mutableStateOf(listOf<RecipeModel>())

    var uiStateLoading by mutableStateOf(true)
    val dataUseCase: DataUseCase = DataUseCase()
    val appUseCase: AppUseCase = AppUseCase(context)

    fun loadRecipes() {
        saveToken()
        execute {
            uiStateLoading = true
            try {
                val response =  dataUseCase.loadRecipes()
                Log.d("servicess",response.toString())
                uiStateListRecipes = response
                uiStateLoading = false
            }catch (e:Exception){
                uiStateLoading = false
            }

        }
    }

    fun saveToken(){
        appUseCase.saveToken("nfmd,s")
    }

}