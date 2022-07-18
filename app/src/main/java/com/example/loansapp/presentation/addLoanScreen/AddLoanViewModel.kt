package com.example.loansapp.presentation.addLoanScreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.usecases.AddLoanUseCase
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.utility.AddLoanData
import kotlinx.coroutines.launch

class AddLoanViewModel: ViewModel() {
    private lateinit var addLoanUseCase: AddLoanUseCase
    private var ready = MutableLiveData<Boolean>(false)

    //not finished
    fun addLoan(addloanData: AddLoanData) {
        viewModelScope.launch {
            ready.value = false
            addLoanUseCase = AddLoanUseCase(addloanData)
            val status = addLoanUseCase.execute()
            ready.value = true
        }
    }

    fun getStatus(): MutableLiveData<Boolean> {
        return ready
    }



}