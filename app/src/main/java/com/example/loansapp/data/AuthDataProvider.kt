package com.example.loansapp.data

import com.example.loansapp.domain.entities.Account
import com.example.loansapp.domain.entities.Status

class AuthDataProvider {


    fun getStatus(login: String, password: String): Status {
        if (login.isBlank()) {
            return Status.LOGIN_IS_EMPTY_ERROR
        }

        //temp solution
        if (login == "Arseny" && password == "password") {
            return Status.SUCCESSFUL
        } else {
            return Status.NOT_SUCCESSFUL
        }

    }
}