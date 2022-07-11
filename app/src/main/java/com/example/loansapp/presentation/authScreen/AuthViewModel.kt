package com.example.loansapp.presentation.authScreen

import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.AuthenticationUseCase
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.Account

class AuthViewModel: ViewModel() {
    private var authUseCase = AuthenticationUseCase()

    private var status = Status.NO_ACTION


    fun loadStatus(login: String, password: String): Status {
        val user = Account(login, password)
        status = authUseCase.execute(user)
        return status
    }

    fun setStatus(newStatus: Status) {
        status = newStatus
    }


}