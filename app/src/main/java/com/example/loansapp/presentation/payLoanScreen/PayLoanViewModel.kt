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

class PayLoanViewModel(): ViewModel() {
    private var chosenLoan = MutableLiveData<Loan>(LoansApp.chosenLoanRepository.getChosenLoan())
    private var ready = MutableLiveData<Boolean>(false)

    //temp solution
    fun payLoan(payment: Int) {

        viewModelScope.launch {
            val amount = chosenLoan.value?.amount
            val amountLeft = chosenLoan.value?.amount_left
            var change = 0

            if (payment + amountLeft!! > amount!!) {
                change = payment - amount + amountLeft
            }

            //transactions
            chosenLoan.value?.amount_left = chosenLoan.value?.amount_left?.minus(payment)!!
            LoansApp.currentAccountRepository.getUser().balance =
                LoansApp.currentAccountRepository.getUser().balance - payment + change
        }

        ready.value = true

    }

    fun getStatus() : LiveData<Boolean> {
        return ready
    }

}