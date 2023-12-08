package com.example.ipapp.domain.usecases

import com.example.ipapp.domain.repository.IPRepository

class GetIPDataUseCase(
    private val ipRepository: IPRepository
) {
    operator fun invoke(ip: String) = ipRepository.getIPData(ip = ip)
}