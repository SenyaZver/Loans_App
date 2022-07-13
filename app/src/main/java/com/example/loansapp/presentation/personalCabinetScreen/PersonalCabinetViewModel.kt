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
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(): ViewModel() {
    private lateinit var loans : MutableLiveData<ArrayList<Loan>>
    private var chosenLoan = MutableLiveData<Loan?>()

    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoadUserDataUseCase



    init {
        viewModelScope.launch {
            loans = MutableLiveData<ArrayList<Loan>>()
            loadLoans()
            loadUser()

            LoansApp.chosenLoanRepository.getChosenLoanFlow().collect {
                chosenLoan.value = it
            }

            LoansApp.loansRepository.getLoansListFlow().collect {
                loans.value = it
            }
            Log.d("debugViewModel", loans.value?.get(0)?.amount_left.toString())

        }
    }


    fun getLoans() : ArrayList<Loan>? {
        return loans.value
    }
    fun getLoansLiveData(): LiveData<ArrayList<Loan>> {
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