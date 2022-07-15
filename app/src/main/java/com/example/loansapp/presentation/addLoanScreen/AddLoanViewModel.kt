package com.example.loansapp.presentation.addLoanScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.UseCases.AddLoanUseCase
import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.launch

class AddLoanViewModel: ViewModel() {
    private lateinit var addLoanUseCase: AddLoanUseCase
    private var ready = MutableLiveData<Boolean>(false)


    fun addLoan(loan: Loan) {
        viewModelScope.launch {
            ready.value = false
            addLoanUseCase = AddLoanUseCase(loan)
            val status = addLoanUseCase.execute()
            ready.value = true
        }
    }

    fun getStatus(): MutableLiveData<Boolean> {
        return ready
    }



}