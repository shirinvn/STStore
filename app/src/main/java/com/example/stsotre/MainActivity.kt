package com.example.stsotre

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.stsotre.nav.BottomNavBar
import com.example.stsotre.ui.theme.STStoreTheme
import com.example.stsotre.util.Constants.PERSION
import com.example.stsotre.util.LocalUtils

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

                LocalUtils.setLocale(LocalContext.current, PERSION)

                CompositionLocalProvider (LocalLayoutDirection provides androidx.compose.ui.unit.LayoutDirection.Rtl){
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


