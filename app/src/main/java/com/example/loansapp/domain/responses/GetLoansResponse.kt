package com.example.loansapp.domain.responses

import com.example.loansapp.domain.entities.Loan

data class GetLoansResponse(
    val loansList: ArrayList<Loan>?,
    val status: Long
)
