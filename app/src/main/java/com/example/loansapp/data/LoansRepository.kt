package com.example.loansapp.data

import android.util.Log
import com.example.loansapp.LoansApp
import com.example.loansapp.data.providers.LoansDataProvider
import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow

class LoansRepository {
//    private var loansList = MutableStateFlow(ArrayList<Loan>())
    private var loansList = ArrayList<Loan>()


    fun setLoansList(newList: ArrayList<Loan>) {
        loansList = newList
//        sortLoansList()
    }

    fun getLoansList(): ArrayList<Loan>  {
        return loansList
    }

//    fun getLoansListFlow(): MutableStateFlow<ArrayList<Loan>> {
//        return loansList
//    }


//    private fun sortLoansList() {
//        loansList.value = loansList.value.sortedWith(compareBy({it.amount_left})) as ArrayList<Loan>
//    }

}