package com.example.loansapp.presentation.payLoanScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.usecases.PayLoanUseCase
import kotlinx.coroutines.launch

class PayLoanViewModel: ViewModel() {
    private var ready = MutableLiveData<Boolean>(false)
    private lateinit var payLoanUseCase: PayLoanUseCase

    //TODO rework with UseCases
    //temp solution
    fun payLoan(payment: Int) {

        viewModelScope.launch {
            payLoanUseCase = PayLoanUseCase()
            payLoanUseCase.execute(payment)
            ready.value = true
        }


    }

    fun getStatus() : LiveData<Boolean> {
        return ready
    }

}