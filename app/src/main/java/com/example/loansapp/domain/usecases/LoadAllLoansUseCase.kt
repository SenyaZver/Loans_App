package com.example.loansapp.domain.usecases

import com.example.loansapp.data.providers.LoansDataProvider
import com.example.loansapp.domain.entities.Status

class LoadAllLoansUseCase(id: Long) {
    private val loansDataProvider = LoansDataProvider(id)

    fun execute(): Status {
        val result = loansDataProvider.provide()
        return result
    }

}