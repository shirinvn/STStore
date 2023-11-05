package com.example.stsotre.data.model

data class ResponseResult <T> (
    val message :String,
    val data:T,
    val success: Boolean

)

