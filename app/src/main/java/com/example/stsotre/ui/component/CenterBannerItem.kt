package com.example.stsotre.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.stsotre.ui.theme.roundedShape
import com.example.stsotre.ui.theme.spacing


@Composable
fun CenterBannerItem(
    imgUrl:String
){

    Card (shape = MaterialTheme.roundedShape.semimedium,
        modifier = Modifier.fillMaxWidth()
            .height(170.dp)
            .padding(MaterialTheme.spacing.medium)){


        Image(painter = rememberAsyncImagePainter(model = imgUrl), contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds)
    }
}