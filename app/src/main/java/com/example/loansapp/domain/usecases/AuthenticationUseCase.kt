package com.example.loansapp.domain.usecases

import com.example.loansapp.data.providers.AuthDataProvider
import com.example.loansapp.domain.entities.Status

class AuthenticationUseCase {
    private var authDataProvider = AuthDataProvider()


    fun execute(phone: String, password: String): Status {
        val result = authDataProvider.provide(phone, password)

        return result
    }
}