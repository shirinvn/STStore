package com.example.stsotre.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.stsotre.util.Constants.USER_LANGUAGE
import com.example.stsotre.viewmodel.DataStoreViewModel

@Composable
fun AppConfig (
    datastore:DataStoreViewModel= hiltViewModel()
){
        getDatastoreVariable(datastore)

}

private  fun getDatastoreVariable(dataStore: DataStoreViewModel){
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(USER_LANGUAGE)
}