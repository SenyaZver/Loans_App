package com.example.loansapp.domain.UseCases

import com.example.loansapp.LoansApp
import com.example.loansapp.data.CurrentAccountRepository
import com.example.loansapp.data.providers.UserDataProvider
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.User

class LoadUserDataUseCase(id: Long) {
    private val userDataProvider = UserDataProvider(id)

    fun execute(): Status {
        val result = userDataProvider.provide()
        return result
    }

}
