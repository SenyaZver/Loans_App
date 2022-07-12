package com.example.loansapp.domain.entities

data class Loan(
    val id: Long,
    val name: String,
    val amount: Double,
    val amount_left: Double,
    val rate: Double,
    val start_date: String,
    val expiration_date: String
)