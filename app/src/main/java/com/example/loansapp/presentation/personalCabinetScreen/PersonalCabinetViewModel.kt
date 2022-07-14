package com.example.loansapp.presentation.personalCabinetScreen

import android.util.Log
import androidx.lifecycle.*
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.LoadAllLoansUseCase
import com.example.loansapp.domain.LoadUserDataUseCase
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.presentation.personalCabinetScreen.util.SingleLiveEvent
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(): ViewModel() {

    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoadUserDataUseCase


    val loanClickEvent = SingleLiveEvent<Loan>()


    init {
        viewModelScope.launch {
            loadLoans()
            loadUser()
        }
    }


    fun loanItemClicked(loan: Loan) {
        loanClickEvent(loan)
    }


    fun getLoans(): LiveData<ArrayList<Loan>> {
        return LoansApp.loansRepository.getLoansListFlow().asLiveData()
    }


    private fun loadUser() {
        loadUserDataUseCase = LoadUserDataUseCase(LoansApp.currentAccountRepository.getId()!!)
        loadUserDataUseCase.execute()
    }
    private fun loadLoans() {
        loadAllLoansUseCase = LoadAllLoansUseCase(LoansApp.currentAccountRepository.getId()!!)
        loadAllLoansUseCase.execute()
    }

}