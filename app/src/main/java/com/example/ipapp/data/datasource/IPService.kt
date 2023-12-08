package com.example.ipapp.data.datasource

import com.example.ipapp.data.datasource.model.IPDataModel
import retrofit2.http.GET

interface IPService {
    @GET("search")
    suspend fun getIPData(): IPDataModel
}