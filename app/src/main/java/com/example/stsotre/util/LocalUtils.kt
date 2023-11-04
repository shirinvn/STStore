package com.example.stsotre.util

import android.content.Context
import android.content.res.Configuration
import java.util.Locale

object LocalUtils {
    fun setLocale (context: Context, language: String)= updateRes(context,language)
    private fun updateRes(context:Context, language:String){

        context.resources.apply {
            val local = Locale(language)
            val config= Configuration(configuration)

            context.createConfigurationContext(configuration)
            Locale.setDefault(local)
            config.setLocale(local)
            context.resources.updateConfiguration(config, displayMetrics)
        }
    }

}