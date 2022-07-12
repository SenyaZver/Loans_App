package com.example.loansapp.presentation.personalCabinetScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loansapp.domain.LoadAllLoansUseCase
import com.example.loansapp.domain.LoanUserDataUseCase
import com.example.loansapp.domain.entities.Loan
import com.example.loansapp.domain.entities.User
import kotlinx.coroutines.launch

class PersonalCabinetViewModel(private val login: String): ViewModel() {
    private var loans : MutableLiveData<ArrayList<Loan>>
    private var user: MutableLiveData<User>
    private lateinit var loadAllLoansUseCase: LoadAllLoansUseCase
    private lateinit var loadUserDataUseCase: LoanUserDataUseCase
    private var adapter: LoansListAdapter
    private var chosenLoan = MutableLiveData<Loan?>()


    init {
        user = MutableLiveData<User>()
        loans = MutableLiveData<ArrayList<Loan>>()
        loadLoans()
        loadUser()

        adapter = loans.value?.let { LoansListAdapter(it, chosenLoan) }!!
    }

    fun getAdapter(): LoansListAdapter {
        return adapter
    }

    fun getLoans(): LiveData<ArrayList<Loan>> {
        return loans
    }

    fun getUser(): LiveData<User> {
        return user
    }

    fun getChosenLoan() : LiveData<Loan?> {
        return chosenLoan
    }
    fun setChosenLoan(loan: Loan?) {
        chosenLoan.value = loan
    }

    fun loadUser() {
        viewModelScope.launch {
            loadUserDataUseCase = LoanUserDataUseCase(login)
            val result = loadUserDataUseCase.execute()
            user.value = result
        }
    }
    fun loadLoans() {
        viewModelScope.launch {
            loadAllLoansUseCase = LoadAllLoansUseCase(login)
            val result = loadAllLoansUseCase.execute()
            loans.value = result
        }

    }

}