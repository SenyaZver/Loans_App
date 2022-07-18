package com.example.loansapp.data.providers

import android.util.Log
import androidx.core.text.isDigitsOnly
import com.example.loansapp.LoansApp
import com.example.loansapp.domain.LoanApi
import com.example.loansapp.domain.entities.Account
import com.example.loansapp.domain.responses.AuthResponse
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.utility.AuthData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthDataProvider {

    fun provide(phone: String, password: String): Status {
        if (phone.isBlank() || !phone.isDigitsOnly()) {
            return Status.PHONE_IS_WRONG
        }


        val response = getResponse(phone, password)

        if (response.id == null) {
            return Status.NOT_SUCCESSFUL
        } else {
            LoansApp.currentAccountRepository.setAccount(Account(response.id!!, phone, password))
            return Status.SUCCESSFUL
        }

    }


    //temp solution
    private fun getResponse(phone: String, password: String): AuthResponse {
        if (phone == "89137906060" && password == "password") {
            return AuthResponse(1)
        } else {
            return AuthResponse(null)
        }
    }

    //test to check backend, but it wasn't hosted :(
    private fun APIgetResponse(phone: String, password: String): AuthResponse {
        var finalResponse: AuthResponse? = null

        LoansApp.retrofit
            .create(LoanApi::class.java)
            .getAuthResponse(AuthData(phone, password))
            .enqueue(object : Callback<AuthResponse> {
                override fun onResponse(
                    call: Call<AuthResponse>,
                    response: Response<AuthResponse>
                ) {
                    finalResponse = response.body()
                }

                override fun onFailure(call: Call<AuthResponse>, t: Throwable) {
                    finalResponse = AuthResponse(null)
                }

            })

        if (finalResponse != null) {
            return finalResponse as AuthResponse
        } else {
            return AuthResponse(null)
        }


    }
}