package com.example.loansapp.data

import android.util.Log
import com.example.loansapp.LoansApp
import com.example.loansapp.data.providers.LoansDataProvider
import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoansRepository {
    private var loansList = ArrayList<Loan>()


    fun setLoansList(newList: ArrayList<Loan>) {
        loansList = newList
//        sortLoansList()
    }

    fun getLoansList() : ArrayList<Loan> {
        return loansList
    }

    fun getLoansListFlow(): Flow<ArrayList<Loan>> = flow {
        emit(loansList)
    }


    private fun sortLoansList() {
        loansList = loansList.sortedWith(compareBy({it.amount_left})) as ArrayList<Loan>
    }

}