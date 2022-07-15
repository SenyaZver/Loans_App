package com.example.loansapp.presentation.personalCabinetScreen

import android.util.Log
import androidx.lifecycle.*
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.UseCases.LoadAllLoansUseCase
import com.example.loansapp.domain.UseCases.LoadUserDataUseCase
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.User
import com.example.loansapp.presentation.personalCabinetScreen.util.SingleLiveEvent
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(): ViewModel() {

    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoadUserDataUseCase


    val loanClickEvent = SingleLiveEvent<Loan>()


    init {

        //this id check is, like, extra bad, but i have so little time :(

        viewModelScope.launch {
            if (LoansApp.currentAccountRepository.getUser().id < 0) {
                loadLoans()
                loadUser()
            }
        }
    }


    fun loanItemClicked(loan: Loan) {
        loanClickEvent(loan)
    }

    fun getUser(): LiveData<User> {
        return LoansApp.currentAccountRepository.getUserFlow().asLiveData()
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