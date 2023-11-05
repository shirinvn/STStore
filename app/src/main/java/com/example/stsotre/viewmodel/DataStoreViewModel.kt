package com.example.stsotre.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stsotre.data.datastore.DataStoreRepository
import com.example.stsotre.util.Constants.PERSION
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository : DataStoreRepository
) : ViewModel(){

    companion object{
        val USER_LANGUAGE_KEY= "USER_LANGUAGE_KEY"
    }
    fun saveUserLanguage(value: String){
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE_KEY, value)
        }

    }

    fun getUserLanguage(): String = runBlocking {
        repository.getString(USER_LANGUAGE_KEY)?: PERSION
    }


}