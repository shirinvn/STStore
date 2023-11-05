package com.example.stsotre.di

import com.example.stsotre.data.remote.HomeApiInterface
import com.example.stsotre.util.Constants.API_KEY
import com.example.stsotre.util.Constants.BASE_URL
import com.example.stsotre.util.Constants.TIME_OUT_IN_SECOUND
import com.example.stsotre.util.Constants.USER_LANGUAGE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {


    @Provides
    @Singleton
    internal fun interceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return logging
    }

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(TIME_OUT_IN_SECOUND, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT_IN_SECOUND, TimeUnit.SECONDS)
        .writeTimeout(TIME_OUT_IN_SECOUND, TimeUnit.SECONDS)
        .addInterceptor{chain->
            val request = chain.request().newBuilder()
                .addHeader("x-api-key", API_KEY)
                .addHeader("lang", USER_LANGUAGE)
            chain.proceed(request.build())
        }
        .addInterceptor(interceptor())
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


}