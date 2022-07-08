package com.example.loansapp.presentation.personalCabinetScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.PersonalCabinetStartUseCase
import com.example.loansapp.domain.entities.Loan

class PersonalCabinetViewModel(private val login: String): ViewModel() {
    private var loans = MutableLiveData<ArrayList<Loan>>()
    private lateinit var personalCabinetStartUseCase: PersonalCabinetStartUseCase

    fun getLoans(): LiveData<ArrayList<Loan>> {
        return loans
    }


    fun loadLoans(login: String) {
        personalCabinetStartUseCase = PersonalCabinetStartUseCase(login)
        val result = personalCabinetStartUseCase.execute()
        if (result != null) {
            loans.value = result!!
        }


    }

}