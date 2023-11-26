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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.stsotre.R
import com.example.stsotre.ui.theme.bottomBar
import com.example.stsotre.ui.theme.selectedBar
import com.example.stsotre.ui.theme.unselectedBar
import com.example.stsotre.util.Constants
import com.example.stsotre.util.LocalUtils


@Composable
fun BottomNavBar(
    navController:NavController,
    modifier:Modifier= Modifier,
    onItemClick: (BottomNavItem)-> Unit

){
    LocalUtils.setLocale(LocalContext.current, Constants.USER_LANGUAGE)



    val items= listOf(
        BottomNavItem(
            name = stringResource(id = R.string.home),
            route = Screen.Home.route,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            deselectedIcon = painterResource(id = R.drawable.home_outline),
            ),
        BottomNavItem(
            name = stringResource(id = R.string.category),
            route = Screen.Category.route,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            deselectedIcon = painterResource(id = R.drawable.category_outline),
        )
        ,
        BottomNavItem(
            name = stringResource(id = R.string.basket),
            route = Screen.Basket.route,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            deselectedIcon = painterResource(id = R.drawable.cart_outline),
        ),
        BottomNavItem(
            name = stringResource(id = R.string.my_digikala),
            route = Screen.Profile.route,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            deselectedIcon = painterResource(id = R.drawable.user_outline),
        )

    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar= backStackEntry.value?.destination?.route in items.map { it.route }



    if (showBottomBar){
        BottomNavigation (
            modifier= Modifier.height(60.dp),
            backgroundColor = MaterialTheme.colors.bottomBar,
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