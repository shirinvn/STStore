package com.example.stsotre.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.stsotre.ui.theme.LocalShape
import com.example.stsotre.ui.theme.LocalSpacing
import com.example.stsotre.ui.theme.darkText


@Composable
fun RoundedIconBox (
    title: String,
    image:Painter,
    bgColor: Color= Color.Transparent,
    onClick: () -> Unit

){


    Column (modifier = Modifier
        .width(80.dp)
        .clickable {
        onClick()
    }, horizontalAlignment = Alignment.CenterHorizontally){

        Box(modifier = Modifier
            .clip(LocalShape.current.biggermedium)
            .background(bgColor)){

            Image(painter = image, contentDescription ="",
                modifier = Modifier.size(52.dp)

            )
        }
        Spacer(modifier = Modifier.height(LocalSpacing.current.small))
        Text(text = title,
            modifier =  Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.darkText,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis)
    }
}