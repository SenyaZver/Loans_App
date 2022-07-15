package com.example.loansapp.domain.usecases

import com.example.loansapp.LoansApp

class AddMoneyUseCase {

    fun execute(amount: Int) {
        LoansApp.currentAccountRepository.getUserFlow().value.balance += amount
    }


}