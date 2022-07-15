package com.example.loansapp.presentation.authScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.usecases.AuthenticationUseCase
import com.example.loansapp.domain.entities.Status
import kotlinx.coroutines.launch

class AuthViewModel(): ViewModel() {
    private var authUseCase = AuthenticationUseCase()

    private var status = Status.NO_ACTION


    fun loadStatus(login: String, password: String): Status {
        viewModelScope.launch {
            status = authUseCase.execute(login, password)
        }

        return status
    }

    fun setStatus(newStatus: Status) {
        status = newStatus
    }


}