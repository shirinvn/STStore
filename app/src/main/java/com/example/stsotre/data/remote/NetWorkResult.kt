package com.example.stsotre.data.remote

sealed class NetWorkResult<T>(
    val message: String? = null,
    val data: T? = null
) {
    class Success<T>(message: String, data: T) : NetWorkResult<T>(message, data)
    class Error<T>(message: String, data: T? = null) : NetWorkResult<T>(message, data)
    class Loading<T> : NetWorkResult<T>()
}
