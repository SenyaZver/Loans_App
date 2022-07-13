package com.example.loansapp.data

import com.example.loansapp.data.providers.LoansDataProvider
import com.example.loansapp.domain.entities.Loan

class LoansRepository {
    private var loansList = ArrayList<Loan>()

    fun setLoansList(newList: ArrayList<Loan>) {
        loansList = newList
    }

    fun getLoansList(): ArrayList<Loan> {
        return loansList
    }

    private fun sortLoansList() {
        loansList = loansList.sortedWith(compareBy({it.amount_left})) as ArrayList<Loan>
    }

}