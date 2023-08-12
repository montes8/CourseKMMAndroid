package com.gb.vale.coursekmmandroid.android.ui.init

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gb.vale.coursekmmandroid.android.MyApplicationTheme
import com.gb.vale.coursekmmandroid.android.application.KmmApplication
import com.gb.vale.coursekmmandroid.android.component.navigation.Navigation
import com.gb.vale.coursekmmandroid.android.ui.init.login.UserViewModel
import com.gb.vale.coursekmmandroid.android.ui.init.splash.SplashViewModel
import com.gb.vale.coursekmmandroid.manager.db.appContext


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContext = this
        setContent {
            MyApplicationTheme {
                val viewModel = SplashViewModel(this)
                 val userViewModel=  UserViewModel()
                Navigation(viewModel,userViewModel)
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
