package com.example.loansapp.domain

import com.example.loansapp.domain.entities.utility.AuthData
import com.example.loansapp.domain.responses.AuthResponse
import com.example.loansapp.domain.responses.GetLoansResponse
import com.example.loansapp.domain.responses.GetUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface LoanApi {

    @POST("/api/login")
    fun getAuthResponse(@Body authData: AuthData): Call<AuthResponse>

    @GET("/api/person/{personId}")
    fun getUserResponse(@Path("personId") id: Long): Call<GetUserResponse>


    @GET("/api/person/{personId}/loans")
    fun getUserLoansResponse(@Path("personId") id: Long): Call<GetLoansResponse>



}