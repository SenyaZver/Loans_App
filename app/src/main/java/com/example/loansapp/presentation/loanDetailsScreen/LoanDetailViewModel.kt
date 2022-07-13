package com.example.loansapp.presentation.loanDetailsScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loansapp.data.ChosenLoanRepository

class LoanDetailViewModel(private var repository: ChosenLoanRepository, private var login:String): ViewModel() {
    private var loanName = MutableLiveData<String>(repository.getChosenLoan()?.name ?: "")
    private var loanId = MutableLiveData<Long>(repository.getChosenLoan()?.id ?: 0)
    private var loanAmount = MutableLiveData<Int>(repository.getChosenLoan()?.amount ?: 0)
    private var loanAmountLeft = MutableLiveData<Int>(repository.getChosenLoan()?.amount_left ?: 0)
    private var loanRate = MutableLiveData<Double>(repository.getChosenLoan()?.rate ?: 0.0)
    private var loanStartDate = MutableLiveData<String>(repository.getChosenLoan()?.start_date ?: "")
    private var loanExpDate = MutableLiveData<String>(repository.getChosenLoan()?.expiration_date ?: "")

    fun getName(): LiveData<String> {
        return loanName
    }
    fun getId(): LiveData<Long> {
        return loanId
    }
    fun getAmount(): LiveData<Int> {
        return loanAmount
    }
    fun getAmountLeft(): LiveData<Int> {
        return loanAmountLeft
    }
    fun getRate(): LiveData<Double> {
        return loanRate
    }
    fun getStartDate(): LiveData<String> {
        return loanStartDate
    }
    fun getExpDate(): LiveData<String> {
        return loanExpDate
    }

}