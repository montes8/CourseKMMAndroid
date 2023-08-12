package com.gb.vale.coursekmmandroid.android.component.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gb.vale.coursekmmandroid.android.component.ROOT_GRAPH_ROUTE
import com.gb.vale.coursekmmandroid.android.component.Screen
import com.gb.vale.coursekmmandroid.android.ui.init.login.ScreenLogin
import com.gb.vale.coursekmmandroid.android.ui.init.login.UserViewModel
import com.gb.vale.coursekmmandroid.android.ui.init.register.ScreenRegister
import com.gb.vale.coursekmmandroid.android.ui.init.splash.ScreenSplash
import com.gb.vale.coursekmmandroid.android.ui.init.splash.SplashViewModel

@Composable
fun Navigation(viewModel: SplashViewModel,userViewModel: UserViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route,
        route = ROOT_GRAPH_ROUTE) {

        composable(route = Screen.SplashScreen.route) {
            ScreenSplash(viewModel, navController = navController)
        }

        composable(route = Screen.LoginScreen.route) {

          ScreenLogin(userViewModel,navController)
        }

        composable(route = Screen.RegisterScreen.route) {
            ScreenRegister(userViewModel,navController) }

    }

}