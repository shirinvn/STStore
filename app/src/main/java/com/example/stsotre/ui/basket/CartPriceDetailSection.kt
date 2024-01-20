package com.example.stsotre.ui.basket

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.stsotre.R
import com.example.stsotre.ui.theme.DigikalaRed
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.util.DigitHelper

@Composable
fun CartPriceDetailSection(){

    Column( modifier = Modifier.padding(MaterialTheme.spacing.medium)) {

        Row (horizontalArrangement = Arrangement.SpaceBetween,
             modifier = Modifier.fillMaxWidth() ){

            Text(text = stringResource(id = R.string.basket_summary),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.darkText)

            Text(text = "${stringResource(id = R.string.goods)} 3",
                style = MaterialTheme.typography.h6,
                color = Color.Gray)

        }


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.semilarge))
        PriceRow(title = "sgbiv ", price = 324)
        PriceRow(title = "sgbiv ", price = 325, 4)

    }
}

@Composable
private  fun PriceRow(
    title:String,
    price:Long,
    discount: Int= 0
){


    var color= MaterialTheme.colors.darkText
    if (discount>0) {
        color= MaterialTheme.colors.DigikalaRed
    }
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){

        Text(text = title,
            style = MaterialTheme.typography.h6,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start
        )

        Row {
            Text(
                text = DigitHelper.digitByLocateAndSeparator(price.toString()),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.SemiBold,
                color = color,
            )

            Icon(
                painter = painterResource(id = R.drawable.toman),
                tint = color,
                contentDescription = "",
                modifier = Modifier
                    .size(24.dp)
                    .padding(MaterialTheme.spacing.extraSmall)
            )
        }

    }
}