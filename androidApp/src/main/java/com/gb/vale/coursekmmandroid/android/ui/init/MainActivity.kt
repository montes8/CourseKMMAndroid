package com.gb.vale.coursekmmandroid.android.ui.init

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gb.vale.coursekmmandroid.android.MyApplicationTheme
import com.gb.vale.coursekmmandroid.android.component.navigation.Navigation
import com.gb.vale.coursekmmandroid.android.ui.init.splash.SplashViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                val viewModel = SplashViewModel(this)
                Navigation(viewModel)
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