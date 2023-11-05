package com.example.stsotre.repository

import com.example.stsotre.data.remote.BaseApiResponse
import com.example.stsotre.data.remote.HomeApiInterface
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse(){

}