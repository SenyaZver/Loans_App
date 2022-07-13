package com.example.loansapp.data

import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ChosenLoanRepository {
    private var chosenLoan: Loan? = null

    fun setChosenLoan(loan:Loan?) {
        chosenLoan = loan
    }

    fun getChosenLoanFlow() : Flow<Loan?> = flow {
        emit(chosenLoan)
    }

    fun getChosenLoan(): Loan? {
        return chosenLoan
    }


}