package com.example.loansapp.presentation.registrationScreen

import androidx.lifecycle.ViewModel
import com.example.loansapp.domain.UseCases.RegistrationUseCase

class RegistrationViewModel: ViewModel() {
    private lateinit var registrationUseCase: RegistrationUseCase

    fun register(
        login: String,
        password: String,
        name: String,
        passportSeries: Int,
        passportNumber: Int,
        email: String,
        pts: String)
    {
        registrationUseCase = RegistrationUseCase()
        registrationUseCase.execute(login, password, name, passportSeries, passportNumber, email, pts)
    }




}