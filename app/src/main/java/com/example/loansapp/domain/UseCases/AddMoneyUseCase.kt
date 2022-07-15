package com.example.loansapp.domain.UseCases

import com.example.loansapp.LoansApp

class AddMoneyUseCase {

    fun execute(amount: Int) {
        LoansApp.currentAccountRepository.getUserFlow().value.balance += amount
    }


}