package com.example.loansapp.domain

import com.example.loansapp.data.LoansRepository
import com.example.loansapp.domain.entities.Loan

class LoadAllLoansUseCase(private val login: String) {
    private val personalCabinetRepository = LoansRepository(login)


    fun execute(): ArrayList<Loan> {
        return personalCabinetRepository.getLoansList()
    }

}