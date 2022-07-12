package com.example.loansapp.data.providers

import com.example.loansapp.domain.entities.Status

class AuthDataProvider {


    fun provide(login: String, password: String): Status {
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