package com.example.loansapp.domain.responses

import com.example.loansapp.domain.entities.User

data class GetUserResponse (
    val user: User?,
    val status: Int
)