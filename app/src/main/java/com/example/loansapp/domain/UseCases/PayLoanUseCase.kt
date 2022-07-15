package com.example.loansapp.domain.UseCases

import com.example.loansapp.LoansApp

class PayLoanUseCase {
    fun execute(payment: Int) {
        val amountLeft = LoansApp.chosenLoanRepository.getChosenLoan().amount_left
        var finalPayment = payment
        if (payment > amountLeft) {
            finalPayment = amountLeft
        }


        //transactions
        LoansApp.chosenLoanRepository.getChosenLoan().amount_left = amountLeft - finalPayment


        LoansApp.currentAccountRepository.getUser().balance =
            LoansApp.currentAccountRepository.getUser().balance - finalPayment
    }

}