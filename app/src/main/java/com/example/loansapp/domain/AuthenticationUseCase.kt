package com.example.loansapp.domain

import com.example.loansapp.data.providers.AuthDataProvider
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.Account

class AuthenticationUseCase {
    private var authDataProvider = AuthDataProvider()


    fun execute(user: Account): Status {
        val result = authDataProvider.provide(user.login, user.password)

        return result
    }
}