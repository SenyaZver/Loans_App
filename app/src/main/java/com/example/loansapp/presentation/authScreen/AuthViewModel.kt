package com.example.loansapp.presentation.authScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.AuthenticationUseCase
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.User

class AuthViewModel: ViewModel() {
    private var authUseCase = AuthenticationUseCase()

    private var status = Status.NO_ACTION


    fun loadStatus(login: String, password: String): Status {
        if (login.isBlank()) {
            status = Status.LOGIN_IS_EMPTY_ERROR
            return status
        }
        val user = User(login, password)
        status = authUseCase.execute(user)
        return status
    }

    fun setStatus(newStatus: Status) {
        status = newStatus
    }


}