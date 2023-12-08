package com.example.ipapp.domain

sealed class NetworkResult<T> {

    data class IOException<T>(val errorMessageRes: Int) : NetworkResult<T>()

    data class HttpException<T>(val errorMessageRes: Int) : NetworkResult<T>()

    data class Success<T>(val data: T) : NetworkResult<T>()
}