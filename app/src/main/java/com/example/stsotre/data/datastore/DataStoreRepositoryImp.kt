package com.example.stsotre.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.stsotre.util.Constants.DATASTORE_NAME
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first
import java.lang.Exception
import javax.inject.Inject

private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = DATASTORE_NAME)



class DataStoreRepositoryImp @Inject constructor(
    private val context: Context
) :DataStoreRepository{
    override suspend fun putString(key: String, value: String) {

        val prefrenceKey = stringPreferencesKey(key)
        context.datastore.edit { prefrences ->
            prefrences[prefrenceKey]= value
        }
    }

    override suspend fun putInt(key: String, value: Int) {
        val prefrenceKey = intPreferencesKey(key)
        context.datastore.edit { prefrences ->
            prefrences[prefrenceKey]= value
        }    }

    override suspend fun getString(key: String): String? {

        return try {
            val prefrenceKey = stringPreferencesKey(key)
            val prefrence= context.datastore.data.first()
            prefrence[prefrenceKey]


        }catch (e:Exception){
            e.printStackTrace()
            null
        }
    }

    override suspend fun getInt(key: String): Int? {
        return try {
            val prefrenceKey = intPreferencesKey(key)
            val prefrence= context.datastore.data.first()
            prefrence[prefrenceKey]


        }catch (e:Exception){
            e.printStackTrace()
            null
        }    }

}