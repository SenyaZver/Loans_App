package com.example.loansapp.domain.usecases

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.utility.AddLoanData
import com.example.loansapp.domain.responses.AddLoanResponse

class AddLoanUseCase(private val addloanData: AddLoanData) {
    fun execute(): Status {

        val response = getResponse(addloanData)
        if (response.loan != null) {
            LoansApp.currentAccountRepository.getUser().balance += addloanData.amount
            LoansApp.loansRepository.getLoansList().add(response.loan)
            return Status.SUCCESSFUL
        }

        return Status.NOT_SUCCESSFUL
    }

    //temp
    private fun getResponse(addloanData: AddLoanData): AddLoanResponse {
        val tempId = LoansApp.loansRepository.getLoansList().size.toLong() + 1
        val loan = Loan(
            tempId,
            addloanData.title,
            addloanData.amount*1.12.toInt(),
            addloanData.amount*1.12.toInt(),
            12.0,
            "15-07-2022",
            addloanData.exp_date
        )

        return AddLoanResponse(loan)
    }

}