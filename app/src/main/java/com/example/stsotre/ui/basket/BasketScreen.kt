package com.example.stsotre.ui.basket

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.stsotre.R
import com.example.stsotre.ui.theme.DigikalaRed
import com.example.stsotre.ui.theme.selectedBar
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.viewmodel.BasketViewModel
import com.example.stsotre.viewmodel.HomeViewModel


@Composable
fun BasketScreen (navController: NavHostController){

   Basket(navController)

}


@Composable
fun Basket(
    navController: NavHostController,
    viewModel: BasketViewModel= hiltViewModel()
){

    var selectedTabByIndex by remember {
        mutableStateOf(0)

    }
    val tabTitles= listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)

    )

    Column {

        TabRow(modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium)
            ,selectedTabIndex = selectedTabByIndex,
            contentColor = MaterialTheme.colors.DigikalaRed,
            backgroundColor = Color.White,
            indicator = {
                line->
                Box(modifier = Modifier
                    .tabIndicatorOffset(line[selectedTabByIndex])
                    .height(3.dp)
                    .background(Color.Red)
                )
            }
        ) {
            tabTitles.forEachIndexed{
                index, title ->
                Tab(
                    selected = (selectedTabByIndex== index),
                    onClick = {
                        selectedTabByIndex= index
                    },
                    selectedContentColor = MaterialTheme.colors.DigikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(text = title,
                                style = MaterialTheme.typography.h6,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                )
            }

        }

        when(selectedTabByIndex){
            0 -> ShoppingCart()
            1 -> NextShoppingCart()
        }
    }


}

