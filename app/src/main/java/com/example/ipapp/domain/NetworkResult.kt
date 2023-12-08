package com.example.ipapp.domain

sealed class NetworkResult<T> {

    data class IOException<T>(val errorMessage: Int) : NetworkResult<T>()

    data class HttpException<T>(val errorMessage: Int) : NetworkResult<T>()

    data class Success<T>(val data: T) : NetworkResult<T>()
}