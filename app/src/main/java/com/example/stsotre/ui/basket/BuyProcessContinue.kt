package com.example.stsotre.ui.basket

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.stsotre.ui.theme.elevation
import com.example.stsotre.ui.theme.roundedShape
import com.example.stsotre.ui.theme.spacing


@Composable
fun BuyProcessContinue(
    price: Long
){
    Card(
        shape = MaterialTheme.roundedShape.extrasmall,
        elevation = MaterialTheme.elevation.extrasmall,
        border = BorderStroke(width = 1.
        dp, color = Color.LightGray.copy(0.2f))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = MaterialTheme.spacing.medium,
                    vertical = MaterialTheme.spacing.medium
                )
        ){
            Button(colors = ButtonDefaults.ContentPadding) {

            }


        }

    }

}