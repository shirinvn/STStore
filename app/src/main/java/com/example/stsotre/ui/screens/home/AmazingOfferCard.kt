package com.example.stsotre.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.stsotre.R
import com.example.stsotre.ui.component.IconWithRotate
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.util.Constants

@Composable
fun AmazingOfferCard( topImageResId : Int, bottomImageResId: Int){


    Column( modifier = Modifier
        .width(160.dp)
        .height(380.dp)
        .padding(
            vertical = MaterialTheme.spacing.medium,
            horizontal = MaterialTheme.spacing.extraSmall
        )
    , horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

        ) {

        Spacer(modifier = Modifier.height(60.dp))
        Image(painter = painterResource(id = topImageResId), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .height(95.dp))

        Spacer(modifier = Modifier.height(15.dp))

        Spacer(modifier = Modifier.height(60.dp))
        Image(painter = amazingLogoChangeByLanguage(),
            contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .height(120.dp))


        Spacer(modifier = Modifier.height(40.dp))


        Row (modifier = Modifier.fillMaxSize()
            , horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom){

            Text(text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.h6,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            IconWithRotate(Icons.Filled.KeyboardArrowLeft)

        }

    }

}

@Composable
private fun amazingLogoChangeByLanguage() : Painter{
    return  if (Constants.USER_LANGUAGE == Constants.ENGLISH){
        painterResource(id = R.drawable.amazing_en)
    }else{
        painterResource(id = R.drawable.amazing_en)

    }

}

