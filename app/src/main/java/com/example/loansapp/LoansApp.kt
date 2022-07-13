package com.example.loansapp

import android.app.Application
import com.example.loansapp.data.ChosenLoanRepository
import com.example.loansapp.data.CurrentAccountRepository
import com.example.loansapp.data.LoansRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoansApp: Application() {
    companion object {
        val baseURL = "http://localhost:8080"
        val currentAccountRepository = CurrentAccountRepository()
        val loansRepository = LoansRepository()
        val chosenLoanRepository = ChosenLoanRepository()


        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}