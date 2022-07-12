package com.example.loansapp.data.providers

import com.example.loansapp.domain.entities.Loan

class LoansDataProvider(private var login: String){

    //temp Solution
    fun provide(): ArrayList<Loan> {

        val loansList = ArrayList<Loan>()

        loansList.add(Loan(
            1,
            "1012",
            5000.0,
            4000.0,
            10.0,
            "11-12-2000",
            "31-12-2000"))
        loansList.add(Loan(
            2,
            "1122",
            5000.0,
            4060.0,
            13.0,
            "7-11-2000",
            "11-12-2001"))
        loansList.add(Loan(
            3,
            "1521",
            5780.0,
            4800.0,
            15.0,
            "21-11-2000",
            "11-12-2002"))

        return loansList
    }

}