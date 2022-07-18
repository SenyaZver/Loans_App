package com.example.loansapp.domain.usecases

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.responses.PaymentResponse

class PayLoanUseCase {
    fun execute(payment: Int): Status {
        if (payment > LoansApp.currentAccountRepository.getUser().balance) {
            return Status.NOT_SUCCESSFUL
        }


        val amountLeft = LoansApp.chosenLoanRepository.getChosenLoan().amount_left
        var finalPayment = payment
        if (payment > amountLeft) {
            finalPayment = amountLeft
        }

        val response = getResponse(finalPayment)
        if (response.id!=null) {
            //transactions
            LoansApp.chosenLoanRepository.getChosenLoan().amount_left = amountLeft - finalPayment

            LoansApp.currentAccountRepository.getUser().balance =
                LoansApp.currentAccountRepository.getUser().balance - finalPayment
            return Status.SUCCESSFUL
        }

        return Status.NOT_SUCCESSFUL
    }

    //temp
    private fun getResponse(payment:Int): PaymentResponse {
        return PaymentResponse(1, "", payment)
    }

}