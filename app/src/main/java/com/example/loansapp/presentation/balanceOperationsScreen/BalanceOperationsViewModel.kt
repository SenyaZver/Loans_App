package com.example.loansapp.presentation.balanceOperationsScreen

import androidx.lifecycle.*
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.User
import kotlinx.coroutines.launch

class BalanceOperationsViewModel: ViewModel() {

    fun addMoney(amount: Int) {
        viewModelScope.launch {
            LoansApp.currentAccountRepository.getUserFlow().value.balance += amount
        }

    }

    fun subtractMoney(amount: Int) {
        viewModelScope.launch {
            LoansApp.currentAccountRepository.getUserFlow().value.balance -= amount
        }
    }

    fun getUser(): LiveData<User> {
        return LoansApp.currentAccountRepository.getUserFlow().asLiveData()
    }
}