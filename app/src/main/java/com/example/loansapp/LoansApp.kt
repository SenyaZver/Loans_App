package com.example.loansapp

import android.app.Application
import com.example.loansapp.data.ChosenLoanRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoansApp: Application() {
    companion object {

        public val chosenLoanRepository = ChosenLoanRepository()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://localhost/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}