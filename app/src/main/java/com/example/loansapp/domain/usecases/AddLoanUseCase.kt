package com.example.loansapp.domain.usecases

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.Status

class AddLoanUseCase(private val loan: Loan, private val amount: Int) {
    fun execute(): Status {
        LoansApp.currentAccountRepository.getUser().balance += amount
        LoansApp.loansRepository.getLoansList().add(loan)
        return Status.SUCCESSFUL
    }

}