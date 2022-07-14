package com.example.loansapp.presentation.loanDetailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.loansapp.LoansApp
import com.example.loansapp.data.ChosenLoanRepository
import com.example.loansapp.domain.entities.Loan

class LoanDetailViewModel(): ViewModel() {

    fun getChosenLoanLiveData(): LiveData<Loan> {
        return LoansApp.chosenLoanRepository.getChosenLoanFlow().asLiveData()
    }

}