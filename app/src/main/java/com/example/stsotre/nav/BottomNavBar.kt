package com.example.stsotre.nav

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stsotre.R
import com.example.stsotre.ui.theme.selectedBar
import com.example.stsotre.ui.theme.unselectedBar




@Composable
fun BottomNavBar(
    navController:NavController,
    modifier:Modifier= Modifier,
    onItemClick: (BottomNavItem)-> Unit

){



    val items= listOf(
        BottomNavItem(
            name = "خانه",
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deselectedIcon = painterResource(id = R.drawable.digi_logo),
            ),
        BottomNavItem(
            name = "دسته بندی",
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deselectedIcon = painterResource(id = R.drawable.digi_logo),
        )
        ,
        BottomNavItem(
            name = "سبد خرید",
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deselectedIcon = painterResource(id = R.drawable.digi_logo),
        ),
        BottomNavItem(
            name = "پروفایل",
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.digi_logo),
            deselectedIcon = painterResource(id = R.drawable.digi_logo),
        )

    )



    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar= backStackEntry.value?.destination?.route in items.map { it.route }



    if (showBottomBar){
        BottomNavigation (
            modifier= modifier,
            backgroundColor = Color.White,
            elevation = 5.dp
        ){

            items.forEachIndexed{ index, item ->
                val seleted = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(selected = seleted
                    , onClick = {onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBar,
                    unselectedContentColor = MaterialTheme.colors.unselectedBar,
                    icon = {
                       Column (
                           horizontalAlignment = Alignment.CenterHorizontally
                       ){
                           if (seleted){
                               Icon(painter = item.selectedIcon,
                                   contentDescription = item.name,
                                   modifier= modifier.height(24.dp))
                           }else{
                               Icon(painter = item.deselectedIcon,
                                   contentDescription =item.name,
                                   modifier= modifier.height(24.dp))
                           }
                           Text(text = item.name
                           , textAlign = TextAlign.Center,
                               style = MaterialTheme.typography.h6)

                       }

                    }
                )
            }

        }
    }
}