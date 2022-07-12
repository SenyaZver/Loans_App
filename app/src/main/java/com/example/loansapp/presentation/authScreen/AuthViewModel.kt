package com.example.loansapp.presentation.authScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.LoansApp
import com.example.loansapp.data.CurrentAccountRepository
import com.example.loansapp.domain.AuthenticationUseCase
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.Account
import kotlinx.coroutines.launch

class AuthViewModel(accountRepository: CurrentAccountRepository): ViewModel() {
    private var authUseCase = AuthenticationUseCase()

    private var status = Status.NO_ACTION


    fun loadStatus(login: String, password: String): Status {
        viewModelScope.launch {
            val user = Account(login, password)
            status = authUseCase.execute(user)
        }
        LoansApp.currentAccountRepository.setAccount(Account(login, password))

        return status
    }

    fun setStatus(newStatus: Status) {
        status = newStatus
    }


}