package com.example.stsotre.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stsotre.nav.Screen
import com.example.stsotre.ui.theme.Purple200
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@Composable
fun ChangeStatusBarColor (
    navController: NavHostController
){

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
                color = Color.White
            )
        }

    }

}