package com.example.loansapp.data.providers

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.responses.GetLoansResponse
import com.example.loansapp.domain.responses.GetUserResponse

class LoansDataProvider(private val id: Long){

    //temp Solution
    fun provide(): Status {

        val response = loadLoansList(id)
        if (response.loansList != null) {
            LoansApp.loansRepository.setLoansList(response.loansList)
            return Status.SUCCESSFUL
        }


        return Status.NOT_SUCCESSFUL
    }

    //temp Solution
    private fun loadLoansList(id:Long): GetLoansResponse {
        val loansList = ArrayList<Loan>()

        loansList.add(Loan(
            1,
            "Первый займ",
            5000,
            4000,
            10.0,
            "11-12-2000",
            "31-12-2000"))
        loansList.add(Loan(
            2,
            "Второй займ",
            5000,
            4060,
            13.0,
            "7-11-2000",
            "11-12-2001"))
        loansList.add(Loan(
            3,
            "третий займ",
            5780,
            4800,
            15.0,
            "21-11-2000",
            "11-12-2002"))

        return GetLoansResponse(loansList, 200)
    }

}