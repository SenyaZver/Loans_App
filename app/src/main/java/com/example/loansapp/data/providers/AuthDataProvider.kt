package com.example.loansapp.data.providers

import androidx.core.text.isDigitsOnly
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Account
import com.example.loansapp.domain.responses.AuthResponse
import com.example.loansapp.domain.entities.Status

class AuthDataProvider {

    fun provide(phone: String, password: String): Status {
        if (phone.isBlank() || !phone.isDigitsOnly()) {
            return Status.PHONE_IS_WRONG
        }


        val response = getResponse(phone, password)

        if (response.id == null) {
            return Status.NOT_SUCCESSFUL
        } else {
            LoansApp.currentAccountRepository.setAccount(Account(response.id!!, phone, password))
            return Status.SUCCESSFUL
        }

    }

    //temp solution
    private fun getResponse(phone: String, password: String): AuthResponse {
        if (phone == "89137903071" && password == "password") {
            return AuthResponse(1, 200)
        } else {
            return AuthResponse(null, 405)
        }
    }
}