package com.example.loansapp.presentation.authScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loansapp.data.CurrentAccountRepository

class AuthViewModelFactory(private val accountRepository: CurrentAccountRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(accountRepository) as T
    }
}