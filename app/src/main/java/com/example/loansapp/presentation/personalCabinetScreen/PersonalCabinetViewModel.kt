package com.example.loansapp.presentation.personalCabinetScreen

import android.util.Log
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
    private lateinit var loans : MutableLiveData<ArrayList<Loan>>

    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoadUserDataUseCase
    private var adapter: LoansListAdapter? = null
    private var chosenLoan = MutableLiveData<Loan?>()


    init {
        viewModelScope.launch {
            loans = MutableLiveData<ArrayList<Loan>>()
            loadLoans()
            loadUser()

            LoansApp.loansRepository.getLoansList().collect {
                loans.value = it
                adapter?.updateItems(it)
            }

            adapter = loans.value?.let { LoansListAdapter(it, chosenLoan) }!!


        }
    }


    fun getAdapter(): LoansListAdapter? {
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
        loadUserDataUseCase = LoadUserDataUseCase(LoansApp.currentAccountRepository.getId()!!)
        loadUserDataUseCase.execute()
    }
    private fun loadLoans() {
        loadAllLoansUseCase = LoadAllLoansUseCase(LoansApp.currentAccountRepository.getId()!!)
        loadAllLoansUseCase.execute()
    }

}