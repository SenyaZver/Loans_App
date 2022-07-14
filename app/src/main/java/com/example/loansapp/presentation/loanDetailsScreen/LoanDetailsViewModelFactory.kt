package com.example.loansapp.presentation.loanDetailsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loansapp.data.ChosenLoanRepository

class LoanDetailsViewModelFactory(private var repository: ChosenLoanRepository,
                                  private var login:String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoanDetailViewModel() as T
    }
}