package com.example.loansapp.data

import com.example.loansapp.data.providers.LoansDataProvider
import com.example.loansapp.domain.entities.Loan

class LoansRepository (login: String) {
    private var loansList: ArrayList<Loan>
    private var loansDataProvider = LoansDataProvider(login)


    init {
        loansList = loansDataProvider.provide()
    }

    fun getLoansList(): ArrayList<Loan> {
        return loansList
    }

}