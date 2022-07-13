package com.example.loansapp.domain.entities

data class Loan(
    val id: Long,
    val name: String,
    val amount: Int,
    var amount_left: Int,
    val rate: Double,
    val start_date: String,
    val expiration_date: String
)