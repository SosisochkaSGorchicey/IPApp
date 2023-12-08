package com.example.ipapp.data.repository

import com.example.ipapp.data.datasource.IPService
import com.example.ipapp.data.httpCodeToErrorMessage
import com.example.ipapp.data.ioExceptionToNetworkResult
import com.example.ipapp.data.toDomain
import com.example.ipapp.domain.NetworkResult
import com.example.ipapp.domain.model.IPData
import com.example.ipapp.domain.repository.IPRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException

class IPRepositoryImpl(
    private val ipService: IPService
) : IPRepository {
    override fun getIPData(ip: String): Flow<NetworkResult<IPData>> = flow {
        try {
            val response = ipService.getIPData(ip = ip).toDomain()
            emit(NetworkResult.Success(response))
        } catch (e: Throwable) {
            when (e) {
                is HttpException -> {
                    emit(
                        NetworkResult.HttpException(
                            errorMessageRes = e.code().httpCodeToErrorMessage()
                        )
                    )
                }

                is IOException -> {
                    emit(NetworkResult.IOException(errorMessageRes = e.ioExceptionToNetworkResult()))
                }
            }
        }
    }.flowOn(Dispatchers.IO)
}