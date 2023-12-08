package com.example.ipapp.data.datasource

import com.example.ipapp.data.datasource.model.IPDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface IPService {
    @GET("ipdata/{ip}")
    suspend fun getIPData(
        @Path("ip") ip: String
    ): IPDataModel
}