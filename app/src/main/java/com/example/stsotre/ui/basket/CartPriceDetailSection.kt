package com.example.stsotre.ui.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.stsotre.R
import com.example.stsotre.data.model.basket.CartDetails
import com.example.stsotre.ui.theme.DigikalaRed
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.util.DigitHelper
import com.example.stsotre.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun CartPriceDetailSection(
    item : CartDetails
){

    Column( modifier = Modifier.padding(MaterialTheme.spacing.medium)) {

        Row (horizontalArrangement = Arrangement.SpaceBetween,
             modifier = Modifier.fillMaxWidth() ){

            Text(text = stringResource(id = R.string.basket_summary),
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.darkText)

            Text(text = "${DigitHelper.digitByLocateAndSeparator(item.totalCount.toString())} ${stringResource(id = R.string.goods)}" ,
                style = MaterialTheme.typography.h6,
                color = Color.Gray)

        }


        Spacer(modifier = Modifier.height(MaterialTheme.spacing.semilarge))
        PriceRow(title = stringResource(id = R.string.good_price), digitByLocateAndSeparator(item.totalPrice.toString()))
        PriceRow(title = stringResource(id = R.string.goods_dicount), price =  digitByLocateAndSeparator(item.totalDisCount.toString()), 4)
        PriceRow(title = stringResource(id = R.string.goods_total_price), price =  digitByLocateAndSeparator(item.payablePrice.toString()), 4)

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Row (modifier = Modifier.fillMaxWidth()
        ,
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically)
        {

            Text(text = stringResource(id = R.string.dot_bullet),
                color = Color.Gray,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(MaterialTheme.spacing.extraSmall))


            Text(text = stringResource(id = R.string.shipping_cost_alert),
                color = Color.Gray,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.weight(1f))

        }

        Divider(
            Modifier
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.small
                )
                .width(2.dp)
                .height(16.dp)
                .alpha(0.6f),
            color = Color.LightGray
        )
        DigiClubStore(score = 7)
    }
}



@Composable
private  fun DigiClubStore(
    score:Int
) {

    Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

    Row (modifier = Modifier.fillMaxWidth()
    , horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){

        Row (horizontalArrangement = Arrangement.Start)
        {
            Image(painter = painterResource(id = R.drawable.digi_score), contentDescription = "",
                modifier = Modifier
                    .size(22.dp)
                    .padding(MaterialTheme.spacing.extraSmall))

            Text(text = stringResource(id = R.string.digi_club_score),
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Medium,
                color= Color.Gray
            )

            Text(text = "${DigitHelper.digitByLocateAndSeparator(score.toString())} ${stringResource(id = R.string.digi_club_score)}",
                style = MaterialTheme.typography.h6,
                fontWeight = FontWeight.Medium,
                color= Color.Gray
            )


        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Text(text = stringResource(id = R.string.shipping_cost_alert),
            color = Color.Gray,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.biggersmall))
    }

}
@Composable
private  fun PriceRow(
    title:String,
    price:String,
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
                text = price,
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