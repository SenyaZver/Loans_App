package com.example.loansapp.domain

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.Status

class AddLoanUseCase(private val loan: Loan) {
    fun execute(): Status {
        LoansApp.loansRepository.getLoansList().add(loan)
        return Status.SUCCESSFUL
    }

}