package com.gb.vale.coursekmmandroid.android.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import com.gb.vale.coursekmmandroid.android.MyApplicationTheme
import com.gb.vale.coursekmmandroid.android.ui.init.splash.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {

    companion object {
        fun newInstance(context: Context) =
            context.startActivity(Intent(context, HomeActivity::class.java))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Box {
                    Text(text = "Holas home")
                }
            }
        }
        val viewModel = SplashViewModel(this)
        viewModel.saveToken()
    }
}




