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
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.stsotre.R
import com.example.stsotre.data.model.basket.CartItem
import com.example.stsotre.ui.theme.darkText
import com.example.stsotre.ui.theme.semiDarkText
import com.example.stsotre.ui.theme.spacing
import com.example.stsotre.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun CartItemCard(
    item: CartItem
){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = MaterialTheme.spacing.extraSmall)) {
        Column( modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.medium)) {

            Row (modifier = Modifier.fillMaxWidth()
            ,
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically){
                Column {
                    Text(text = stringResource(id = R.string.your_shopping_list),
                        style = MaterialTheme.typography.h4
                    ,
                        fontWeight = FontWeight.Bold,
                        color= MaterialTheme.colors.darkText
                    )
                    Text(text = "${digitByLocateAndSeparator("1")} کالا "
                    ,
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray)
                }
                Icon(imageVector = Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = MaterialTheme.colors.darkText)


            }

            Spacer(modifier = Modifier.height(12.dp))

            Row (modifier = Modifier.fillMaxWidth()
                , verticalAlignment = Alignment.CenterVertically){
                Image(painter = rememberAsyncImagePainter(model = item.image)
                    , contentDescription ="",
                    modifier = Modifier
                        .width(130.dp)
                        .height(90.dp))

                Column(modifier = Modifier.weight(.7f)) {
                    Text(text = item.name,
                        style = MaterialTheme.typography.h6,
                        color= MaterialTheme.colors.darkText,
                        fontWeight = FontWeight.SemiBold,
                        maxLines = 2,
                        modifier=Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)
                        )


                    DetailRow(icon = painterResource(id = R.drawable.empty_cart),
                        text ="کالای شما غاونه هسا کع دو نیشعه عز کذدز " , color =
                    MaterialTheme.colors.darkText)


                    DetailRow(icon = painterResource(id = R.drawable.empty_cart),
                        text ="کالای شما غاونه هسا کع دو نیشعه عز کذدز " , color =
                    MaterialTheme.colors.darkText)


                    DetailRow(icon = painterResource(id = R.drawable.empty_cart),
                        text ="کالای شما غاونه هسا کع دو نیشعه عز کذدز " , color =
                    MaterialTheme.colors.darkText)

                    DetailRow(icon = painterResource(id = R.drawable.empty_cart),
                        text ="کالای شما غاونه هسا کع دو نیشعه عز کذدز " , color =
                    MaterialTheme.colors.darkText)


                    DetailRow(icon = painterResource(id = R.drawable.empty_cart),
                        text ="کالای شما غاونه هسا کع دو نیشعه عز کذدز " , color =
                    MaterialTheme.colors.darkText)

                }

            }
        }

    }
}

@Composable
fun DetailRow(
    icon: Painter,
    text: String,
    color: Color
){




    Row (modifier = Modifier.padding(vertical = MaterialTheme.spacing.extraSmall)){

        Icon(painter = icon, contentDescription = "",
            modifier=Modifier.size(18.dp)
        , tint = color)
        Spacer(modifier = Modifier.width(MaterialTheme.spacing.semilarge))

Text(text = text,
    style = MaterialTheme.typography.h6,
    fontWeight = FontWeight.SemiBold,
    color= MaterialTheme.colors.semiDarkText
)
    }


}