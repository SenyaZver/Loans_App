package com.example.loansapp.domain.entities

data class User (
    val name: String,
    val surname: String,
    val patronymic: String?,
    val balance: Double,
    val passport_series: Int,
    val passport_number: Int,
    val telephone: Int,
    val email: Int,
    val pts: String?
        )