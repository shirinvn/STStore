package com.example.stsotre

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.stsotre.nav.Screen
import com.example.stsotre.ui.screens.BasketScreen
import com.example.stsotre.ui.screens.category.CategoryScreen
import com.example.stsotre.ui.screens.home.HomeScreen
import com.example.stsotre.ui.screens.ProfileScreen
import com.example.stsotre.ui.screens.SplashScreen
import com.example.stsotre.ui.screens.home.WebPageScreen


@Composable
fun SetUpNavGraph(navController: NavHostController){


    NavHost(navController = navController, startDestination = Screen.Splash.route ){

        composable(route = Screen.Splash.route){
            SplashScreen(navController = navController)
        }


        composable(route = Screen.Home.route){
            HomeScreen(navController = navController)
        }

        composable(route = Screen.Category.route){
           CategoryScreen(navController = navController)
        }

        composable(route = Screen.Basket.route){
            BasketScreen(navController = navController)
        }

        composable(route = Screen.Profile.route){
            ProfileScreen(navController = navController)
        }




   composable(route = Screen.WebView.route+"?url={url}",
      arguments = listOf(navArgument("url"){
          type= NavType.StringType
          defaultValue =""
          nullable= true
      })){
       val url = it.arguments?.getString("url")
       url?.let {
           WebPageScreen(navController = navController, url = url)
       }
   }


    }
}
