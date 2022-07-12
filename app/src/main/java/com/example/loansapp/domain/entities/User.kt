package com.example.loansapp.domain.entities

data class User (
    val id: Long,
    val name: String,
    val surname: String,
    val patronymic: String?,
    val balance: Int,
    val passport_series: Int,
    val passport_number: Int,
    val telephone: String,
    val email: String,
    val pts: String?
        )