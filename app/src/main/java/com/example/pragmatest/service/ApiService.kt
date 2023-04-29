package com.example.pragmatest.service

import com.example.pragmatest.model.Cat
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    companion object{
        const val BASE_URL = "https://api.thecatapi.com/v1/"
    }

    @Headers("x-api-key: bda53789-d59e-46cd-9bc4-2936630fde39")
    @GET("breeds")
    suspend fun getCatList(): Response<List<Cat>>
}