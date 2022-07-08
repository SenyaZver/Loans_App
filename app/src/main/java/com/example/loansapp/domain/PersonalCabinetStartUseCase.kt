package com.example.loansapp.domain

import com.example.loansapp.data.PersonalCabinetRepository
import com.example.loansapp.domain.entities.Loan

class PersonalCabinetStartUseCase(private val login: String) {
    private val personalCabinetRepository = PersonalCabinetRepository(login)


    fun execute(): ArrayList<Loan>? {
        return personalCabinetRepository.getLoansList()
    }

}