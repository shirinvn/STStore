package com.example.stsotre.data.remote

import com.example.stsotre.data.model.ResponseResult
import com.example.stsotre.data.model.category.SubCategory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import java.lang.Exception

abstract class BaseApiResponse {

        suspend fun <T> safeApiCall(apiCall: suspend () -> Response<ResponseResult<T>>): NetWorkResult<T> =
            withContext(Dispatchers.IO) {
                try {
                    val response = apiCall()
                    if (response.isSuccessful) {
                        val body = response.body()
                        body?.let {
                            return@withContext NetWorkResult.Success(body.message, body.data)
                        }
                    }
                    return@withContext error("code : ${response.code()} , message : ${response.message()}")
                } catch (e: Exception) {
                    return@withContext error(e.message ?: e.toString())
                }
            }


        private fun <T> error(errorMessage: String): NetWorkResult<T> =
            NetWorkResult.Error("Api call failed : $errorMessage")
    }
