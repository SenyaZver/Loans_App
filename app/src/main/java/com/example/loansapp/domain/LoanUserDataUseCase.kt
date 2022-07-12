package com.example.loansapp.domain

import com.example.loansapp.data.providers.UserDataProvider
import com.example.loansapp.domain.entities.User

class LoanUserDataUseCase(login: String) {
    private val userDataProvider = UserDataProvider(login)

    fun execute(): User {
        return userDataProvider.provide()
    }

}
