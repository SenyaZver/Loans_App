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
            12.0,
            "11-07-2022",
            "31-07-2022"))
        loansList.add(Loan(
            2,
            "Второй займ",
            5000,
            4060,
            12.0,
            "17-07-2033",
            "31-08-2022"))
        loansList.add(Loan(
            3,
            "Третий займ",
            5780,
            4800,
            12.0,
            "21-07-2022",
            "11-08-2022"))

        return GetLoansResponse(loansList, 200)
    }

}