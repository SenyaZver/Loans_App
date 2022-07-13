package com.example.loansapp.domain.entities.utility

import com.google.gson.annotations.SerializedName

data class AuthData (
    @SerializedName("login") val phone: String,
    val password: String
)