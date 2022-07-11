package com.example.loansapp.presentation.personalCabinetScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.PersonalCabinetStartUseCase
import com.example.loansapp.domain.entities.Loan
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(private val login: String): ViewModel() {
    private var loans : MutableLiveData<ArrayList<Loan>>
    private var balance : MutableLiveData<Double>
    private lateinit var personalCabinetStartUseCase: PersonalCabinetStartUseCase

    //call REST API
    init {
        balance = MutableLiveData<Double>(0.0)
        loans = MutableLiveData<ArrayList<Loan>>()
        loadLoans(login)
    }

    fun getLoans(): LiveData<ArrayList<Loan>> {
        return loans
    }


    fun loadLoans(login: String) {
        viewModelScope.launch {
            personalCabinetStartUseCase = PersonalCabinetStartUseCase(login)
            val result = personalCabinetStartUseCase.execute()
            loans.value = result!!
        }

    }

}