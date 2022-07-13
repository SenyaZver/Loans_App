package com.example.loansapp.presentation.personalCabinetScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.LoadAllLoansUseCase
import com.example.loansapp.domain.LoadUserDataUseCase
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.User
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(): ViewModel() {
    private var loans : MutableLiveData<ArrayList<Loan>>

    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoadUserDataUseCase
    private var adapter: LoansListAdapter
    private var chosenLoan = MutableLiveData<Loan?>()


    init {
        loans = MutableLiveData<ArrayList<Loan>>()
        loadLoans()
        loadUser()

        loans.value = LoansApp.loansRepository.getLoansList()


        adapter = loans.value?.let { LoansListAdapter(it, chosenLoan) }!!
    }

    fun getAdapter(): LoansListAdapter {
        return adapter
    }

    fun getLoans(): LiveData<ArrayList<Loan>> {
        return loans
    }


    fun getChosenLoan() : LiveData<Loan?> {
        return chosenLoan
    }
    fun setChosenLoan(loan: Loan?) {
        chosenLoan.value = loan
    }

    private fun loadUser() {
        viewModelScope.launch {
            loadUserDataUseCase = LoadUserDataUseCase(LoansApp.currentAccountRepository.getId()!!)
            loadUserDataUseCase.execute()
        }

    }
    private fun loadLoans() {
        viewModelScope.launch {
            loadAllLoansUseCase = LoadAllLoansUseCase(LoansApp.currentAccountRepository.getId()!!)
            loadAllLoansUseCase.execute()
        }

    }

}