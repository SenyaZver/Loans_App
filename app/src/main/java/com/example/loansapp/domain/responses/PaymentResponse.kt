package com.example.loansapp.domain.responses

import com.google.gson.annotations.SerializedName

data class PaymentResponse (
    val id: Long?,
    @SerializedName("time") val date: String?,
    val amount: Int?
        )