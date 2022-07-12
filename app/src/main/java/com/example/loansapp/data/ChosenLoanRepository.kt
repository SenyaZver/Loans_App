package com.example.loansapp.data

import com.example.loansapp.domain.entities.Loan

class ChosenLoanRepository {
    private var chosenLoan: Loan? = null

    fun setChosenLoan(loan:Loan?) {
        chosenLoan = loan
    }

    fun getChosenLoan(): Loan? {
        return chosenLoan
    }


}