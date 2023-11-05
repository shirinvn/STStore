package com.example.stsotre.ui.screens
import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.datastore.dataStore
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.stsotre.MainActivity
import com.example.stsotre.util.Constants.ENGLISH
import com.example.stsotre.util.Constants.PERSION
import com.example.stsotre.viewmodel.DataStoreViewModel


@Composable
fun ProfileScreen (navController: NavHostController,
                   dataStore: DataStoreViewModel = hiltViewModel()){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val activity= LocalContext.current as Activity


        Button(onClick = {
            dataStore.saveUserLanguage(PERSION)
            activity.apply {
               finish()
               startActivity(Intent(activity, MainActivity::class.java))

            }

        }) {

            Text(text = "Fa")

        }

        Button(onClick = {
            dataStore.saveUserLanguage(ENGLISH)

            activity.apply {
                finish()
                startActivity(Intent(activity, MainActivity::class.java))

            }
        }) {

            Text(text = "En")

        }


    }



}