package com.example.stsotre.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.stsotre.R
import com.example.stsotre.ui.component.RoundedIconBox
import com.example.stsotre.ui.theme.LocalSpacing


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
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})


            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

        }


        Row (horizontalArrangement = Arrangement.SpaceBetween
            ,modifier = Modifier
            .fillMaxSize()
            .padding(vertical = LocalSpacing.current.semismall)){

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})


            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

            RoundedIconBox(title = stringResource(id = R.string.digikala_jet)
                , image = painterResource(id = R.drawable.digijet),
                onClick = {})

        }

    }
}


