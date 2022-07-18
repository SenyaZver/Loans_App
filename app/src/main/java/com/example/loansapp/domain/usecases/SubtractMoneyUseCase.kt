package com.example.loansapp.domain.usecases

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.responses.BalanceChangeResponse

class SubtractMoneyUseCase {

    fun execute(amount: Int): Status {

        if (LoansApp.currentAccountRepository.getUserFlow().value.balance < amount) {
            return Status.NOT_SUCCESSFUL
        }

        val response = getResponse(amount)
        if (response.balance!=null) {
            LoansApp.currentAccountRepository.getUserFlow().value.balance -= amount
            return Status.SUCCESSFUL
        }

        return Status.NOT_SUCCESSFUL
    }

    //temp
    private fun getResponse(amount: Int): BalanceChangeResponse {
        return BalanceChangeResponse(amount)
    }
}