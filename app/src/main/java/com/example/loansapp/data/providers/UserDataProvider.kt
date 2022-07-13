package com.example.loansapp.data.providers

import com.example.loansapp.LoansApp
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.User
import com.example.loansapp.domain.responses.GetUserResponse

class UserDataProvider(private val id: Long) {

    fun provide(): Status {

        val response = getResponse(id)
        if (response.user!=null) {
            LoansApp.currentAccountRepository.setUser(response.user)
            return Status.SUCCESSFUL
        }

        return Status.NOT_SUCCESSFUL
    }

    //temp solution
    private fun getResponse(id:Long): GetUserResponse {
        val user = User(
            1,
            "Arseny",
            "Stuchinsky",
            null,
            10000,
            1255,
            848549,
            null)

        return GetUserResponse(user, 200)
    }

}