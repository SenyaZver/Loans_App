package com.example.loansapp.presentation.registrationScreen

import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.usecases.RegistrationUseCase

class RegistrationViewModel: ViewModel() {
    private lateinit var registrationUseCase: RegistrationUseCase

    fun register(
        login: String,
        password: String,
        name: String,
        passportSeries: Int,
        passportNumber: Int,
        email: String,
        pts: String): Status
    {
        registrationUseCase = RegistrationUseCase()
        val status = registrationUseCase.execute(login, password, name, passportSeries, passportNumber, email, pts)
        return status
    }




}