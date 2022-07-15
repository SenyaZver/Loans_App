package com.example.loansapp.domain.usecases

import com.example.loansapp.data.providers.UserDataProvider
import com.example.loansapp.domain.entities.Status

class LoadUserDataUseCase(id: Long) {
    private val userDataProvider = UserDataProvider(id)

    fun execute(): Status {
        val result = userDataProvider.provide()
        return result
    }

}
