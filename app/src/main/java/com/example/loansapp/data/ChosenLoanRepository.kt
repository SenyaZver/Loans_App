package com.example.loansapp.data

import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.flow.MutableStateFlow

class ChosenLoanRepository {
    private var chosenLoan = MutableStateFlow(Loan(-1,"",0, 0,0.0, "", ""))

    fun getChosenLoanFlow() : MutableStateFlow<Loan> {
        return chosenLoan
    }

    fun setChosenLoan(loan:Loan) {
        chosenLoan.value = loan
    }

    fun getChosenLoan(): Loan {
        return chosenLoan.value
    }


}