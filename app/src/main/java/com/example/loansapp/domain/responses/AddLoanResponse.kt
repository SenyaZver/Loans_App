package com.example.loansapp.domain.responses

import com.example.loansapp.domain.entities.Loan

data class AddLoanResponse(
    val loan: Loan?
)
