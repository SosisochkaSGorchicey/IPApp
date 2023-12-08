package com.example.ipapp.domain.repository

import com.example.ipapp.domain.NetworkResult
import com.example.ipapp.domain.model.IPData
import kotlinx.coroutines.flow.Flow

interface IPRepository {
    fun getIPData(ip: String): Flow<NetworkResult<IPData>>
}