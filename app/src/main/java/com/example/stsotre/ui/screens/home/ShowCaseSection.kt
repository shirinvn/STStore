package com.example.stsotre.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stsotre.R
import com.example.stsotre.nav.Screen
import com.example.stsotre.ui.component.RoundedIconBox
import com.example.stsotre.ui.theme.LocalSpacing
import com.example.stsotre.ui.theme.amber
import com.example.stsotre.ui.theme.grayCategory


@Composable
fun ShowCaseSection(navController: NavController){

    Column( modifier = Modifier
        .fillMaxSize()
        .padding(
            horizontal = LocalSpacing.current.semimedium,
            vertical = LocalSpacing.current.biggersmall
        )) {

        Row (horizontalArrangement = Arrangement.SpaceBetween
            ,modifier = Modifier
            .fillMaxSize()
            .padding(vertical = LocalSpacing.current.semismall)){

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                )
            )

            RoundedIconBox(title = stringResource(id = R.string.digi_style)
                , image = painterResource(id = R.drawable.auction),
                onClick = onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ))

            RoundedIconBox(title = stringResource(id = R.string.digi_pay)
                , image = painterResource(id = R.drawable.digipay),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ))


            RoundedIconBox(title = stringResource(id = R.string.pindo)
                , image = painterResource(id = R.drawable.pindo),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                )
            ,bgColor = MaterialTheme.colors.amber)



        }


        Row (horizontalArrangement = Arrangement.SpaceBetween
            ,modifier = Modifier
            .fillMaxSize()
            .padding(vertical = LocalSpacing.current.semismall)){

            RoundedIconBox(title = stringResource(id = R.string.digi_shoping)
                , image = painterResource(id = R.drawable.shopping),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ))

            RoundedIconBox(title = stringResource(id = R.string.gift_card)
                , image = painterResource(id = R.drawable.giftcard),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ))

            RoundedIconBox(title = stringResource(id = R.string.digi_plus)
                , image = painterResource(id = R.drawable.digiplus),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ))


            RoundedIconBox(title = stringResource(id = R.string.more)
                , image = painterResource(id = R.drawable.more),
                onClick =  onBoxClick(
                    navController = navController,
                    url = "https://www.digikalajet.com/user/address"
                ),
                bgColor = MaterialTheme.colors.grayCategory)
        }

    }
}


@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.route + "?url=${url}") }


