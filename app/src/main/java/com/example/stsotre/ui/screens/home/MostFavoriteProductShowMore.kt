package com.example.stsotre.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stsotre.R
import com.example.stsotre.ui.theme.DarkCyan
import com.example.stsotre.ui.theme.DigiKalaRed
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.roundedShape
import com.example.stsotre.ui.theme.spacing

@Composable
fun MostFavoriteProductShowMore (){

    Column( modifier = Modifier
        .size(180.dp, 375.dp)
        .background(Color.White)
        .padding(
            end = MaterialTheme.spacing.medium,
            start = MaterialTheme.spacing.semismall,
            top = MaterialTheme.spacing.semilarge
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

            Icon(
                painter = painterResource(id = R.drawable.show_more),
                contentDescription = "",
                tint = MaterialTheme.colors.DarkCyan,
                modifier = Modifier.size(40.dp, 40.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.SemiBold,
                color= MaterialTheme.colors.darkText
            )

    }
}