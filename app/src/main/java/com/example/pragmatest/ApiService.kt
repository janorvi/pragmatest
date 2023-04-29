package com.example.pragmatest

import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiService {

    companion object{
        const val BASE_URL = "https://api.thecatapi.com/v1/"
    }

    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @POST("breeds")
    suspend fun getCatList(): Response<List<Cat>>
}