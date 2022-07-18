package com.example.loansapp.domain.usecases

import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.responses.RegistrationResponse

class RegistrationUseCase()
{

    fun execute(
        login: String,
        password: String,
        name: String,
        passportSeries: Int,
        passportNumber: Int,
        email: String,
        pts: String) : Status
    {

        //TODO
        val response = getRegisterResponse()
        if (response.id != null) {
            return Status.SUCCESSFUL
        } else {
            return Status.NOT_SUCCESSFUL
        }

    }

    //temp
    private fun getRegisterResponse(): RegistrationResponse {
        return RegistrationResponse(1)
    }

}