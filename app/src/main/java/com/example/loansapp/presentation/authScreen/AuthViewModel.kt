package com.example.loansapp.presentation.authScreen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.AuthenticationUseCase
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.User

class AuthViewModel: ViewModel() {
    private var authUseCase = AuthenticationUseCase()

    private var name = MutableLiveData<String>("")
    private var password = MutableLiveData<String>("")
    private var status = MutableLiveData<Status>(Status.NO_ACTION)


    fun loadStatus(login: String, password: String) {
        val user = User(login, password)
        status.value = authUseCase.execute(user)
    }

    fun getName(): LiveData<String> {
        return name
    }

    fun getPassword(): LiveData<String> {
        return password
    }

    fun getStatus(): LiveData<Status> {
        return status
    }




}