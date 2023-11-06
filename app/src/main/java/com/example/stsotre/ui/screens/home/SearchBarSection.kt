package com.example.stsotre.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.stsotre.R
import com.example.stsotre.ui.theme.LocalElevation
import com.example.stsotre.ui.theme.LocalShape
import com.example.stsotre.ui.theme.LocalSpacing
import com.example.stsotre.ui.theme.searchBarBg
import com.example.stsotre.ui.theme.unselectedBar
import com.example.stsotre.util.Constants.ENGLISH
import com.example.stsotre.util.Constants.USER_LANGUAGE


@Composable
fun SearchBarSection(){


    Card( modifier = Modifier
        .fillMaxWidth()
        .height(65.dp)
        .background(Color.White),
        elevation = LocalElevation.current.extraSmall) {

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(LocalSpacing.current.small)
            .clip(LocalShape.current.bigersmall)
            .background(MaterialTheme.colors.searchBarBg)){

            SearchContent()
        }

    }
}

@Composable
private  fun SearchContent(){
    Row (modifier = Modifier
        .fillMaxSize()
        .padding(start = 20.dp)
    , verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start) {

        Icon(modifier = Modifier.height(24.dp), contentDescription ="",
            painter = painterResource(id = R.drawable.search))

        Text(text = stringResource(id = R.string.search_in),
            modifier = Modifier.padding(start = 20.dp),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.unselectedBar,
            style = MaterialTheme.typography.h2,
            fontWeight = FontWeight.Normal
        )

        Image(modifier = Modifier
            .width(80.dp)
            .padding(start = 5.dp),
            painter = digiKalaChangeByLanguage(), contentDescription = "")
    }
}

@Composable
private fun  digiKalaChangeByLanguage(): Painter {
    return  if (USER_LANGUAGE == ENGLISH)
    {
        painterResource(id = R.drawable.digi_red_english)
    }else{
        painterResource(id = R.drawable.digi_red_persian)


    }
}
