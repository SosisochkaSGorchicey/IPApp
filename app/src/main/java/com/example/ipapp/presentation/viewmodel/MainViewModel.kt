package com.example.ipapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ipapp.R
import com.example.ipapp.domain.NetworkResult
import com.example.ipapp.domain.model.IPData
import com.example.ipapp.domain.usecases.GetIPDataUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.net.Inet4Address
import java.net.NetworkInterface
import java.net.SocketException


class MainViewModel(
    private val getIPDataUseCase: GetIPDataUseCase
) : ViewModel() {

    private val _ipData = MutableStateFlow(IPData())
    val ipData = _ipData.asStateFlow()

    private val _errorForDisplayRes = MutableStateFlow(R.string.empty)
    val errorForDisplayRes: StateFlow<Int> = _errorForDisplayRes

    private val _ipIsCurrent = MutableStateFlow(false)
    val ipIsCurrent = _ipIsCurrent.asStateFlow()

    fun setIpIsCurrent() {
        _ipIsCurrent.value = true
    }

    fun setIpIsNotCurrent() {
        _ipIsCurrent.value = false
    }

    fun getIpData(ip: String) {
        viewModelScope.launch {
            getIPDataUseCase(ip = ip).collect { result ->
                when (result) {
                    is NetworkResult.Success -> {
                        _errorForDisplayRes.value = R.string.empty
                        _ipData.value = result.data
                    }

                    is NetworkResult.IOException -> {
                        _errorForDisplayRes.value = result.errorMessageRes
                    }

                    is NetworkResult.HttpException -> {
                        _errorForDisplayRes.value = result.errorMessageRes
                    }
                }
            }
        }
    }

}