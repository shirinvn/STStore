package com.example.stsotre.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stsotre.nav.Screen
import com.example.stsotre.ui.theme.Purple200
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import okhttp3.internal.wait


@Composable
fun ChangeStatusBarColor (
    navController: NavHostController
){

    val statusBarColor = if (MaterialTheme.colors.isLight){
        Color.White
    }else{
        Color.Black
    }
    val navbaCkStackEntry by navController.currentBackStackEntryAsState()
    val systemUIController = rememberSystemUiController()

    when (navbaCkStackEntry?.destination?.route){
        Screen.Splash.route ->
        {
            SideEffect {
                systemUIController.setStatusBarColor(
                    color = Purple200
                )
            }

        }else -> {
            systemUIController.setStatusBarColor(
                color = statusBarColor
            )
        }

    }

}