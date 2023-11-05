package com.example.stsotre

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stsotre.nav.BottomNavBar
import com.example.stsotre.ui.component.AppConfig
import com.example.stsotre.ui.component.ChangeStatusBarColor
import com.example.stsotre.ui.theme.STStoreTheme
import com.example.stsotre.util.Constants.ENGLISH
import com.example.stsotre.util.Constants.PERSION
import com.example.stsotre.util.Constants.USER_LANGUAGE
import com.example.stsotre.util.LocalUtils
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            STStoreTheme {
                navController = rememberNavController()
                ChangeStatusBarColor(navController)
                AppConfig()

                Log.e("3636", USER_LANGUAGE)
                LocalUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                val direction = if (USER_LANGUAGE == ENGLISH){
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                }else {
                    androidx.compose.ui.unit.LayoutDirection.Rtl

                }

                CompositionLocalProvider (LocalLayoutDirection provides direction){
                    Scaffold(
                        bottomBar = {
                            BottomNavBar(
                                navController = navController,
                                onItemClick = {
                                    navController.navigate(it.route)
                                })
                        }
                    ) {
                        SetUpNavGraph(navController = navController)
                    }

                }


            }
        }
    }
}


