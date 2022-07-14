package com.example.loansapp.presentation.payLoanScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PayLoanViewModel: ViewModel() {
    private var ready = MutableLiveData<Boolean>(false)

    //TODO rework with UseCases
    //temp solution
    fun payLoan(payment: Int) {

        viewModelScope.launch {
            val amountLeft = LoansApp.chosenLoanRepository.getChosenLoan().amount_left
            var finalPayment = payment
            if (payment > amountLeft) {
                finalPayment = amountLeft
            }


            //transactions
            LoansApp.chosenLoanRepository.getChosenLoan().amount_left = amountLeft - finalPayment


            LoansApp.currentAccountRepository.getUser().balance =
                LoansApp.currentAccountRepository.getUser().balance - finalPayment
        }

        ready.value = true

    }

    fun getStatus() : LiveData<Boolean> {
        return ready
    }

}