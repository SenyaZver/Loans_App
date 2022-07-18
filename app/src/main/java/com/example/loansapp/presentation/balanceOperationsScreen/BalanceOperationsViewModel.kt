package com.example.loansapp.presentation.balanceOperationsScreen

import androidx.lifecycle.*
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.User
import com.example.loansapp.domain.usecases.AddMoneyUseCase
import com.example.loansapp.domain.usecases.SubtractMoneyUseCase

import kotlinx.coroutines.launch

class BalanceOperationsViewModel: ViewModel() {
    private lateinit var addMoneyUseCase: AddMoneyUseCase
    private lateinit var subtractMoneyUseCase: SubtractMoneyUseCase

    fun addMoney(amount: Int) {
        viewModelScope.launch {
            addMoneyUseCase = AddMoneyUseCase()
            addMoneyUseCase.execute(amount)
        }

    }

    fun subtractMoney(amount: Int) {
        viewModelScope.launch {
            subtractMoneyUseCase = SubtractMoneyUseCase()
            subtractMoneyUseCase.execute(amount)
        }
    }

    fun getUser(): LiveData<User> {
        return LoansApp.currentAccountRepository.getUserFlow().asLiveData()
    }
}