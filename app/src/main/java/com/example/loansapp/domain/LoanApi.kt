package com.example.loansapp.domain

import com.example.loansapp.domain.entities.utility.AuthData
import com.example.loansapp.domain.responses.*
import retrofit2.Call
import retrofit2.http.*

interface LoanApi {
    //TODO finish api
    //can't test it because the server is not hosted, so everything is local now :(


    @POST("/api/login")
    fun getAuthResponse(@Body authData: AuthData): Call<AuthResponse>

    @GET("/api/person/{personId}")
    fun getUserResponse(@Path("personId") id: Long): Call<GetUserResponse>

    @GET("/api/person/{personId}/loans")
    fun getUserLoansResponse(@Path("personId") id: Long): Call<GetLoansResponse>


    @POST("/api/person/{idPerson}")
    fun getRegisterResponse(@Path("idPerson") id: Long): Call<RegistrationResponse>

    @POST("/api/person/{personId}/loans")
    fun addLoanResponse(@Path("personId") id: Long): Call<AddLoanResponse>

    @GET("/api/person/{personId}/loans")
    fun getAllLoansResponse(@Path("personId") id: Long): Call<GetLoansResponse>

    @POST("/api/person/{personId}/balance")
    fun getAddBalanceResponse(@Path("personId") id: Long): Call<BalanceChangeResponse>

    @PUT("/api/person/{personId}/balance")
    fun getSubtractBalanceResponse(@Path("personId") id: Long): Call<BalanceChangeResponse>

    @POST("/api/person/{personId}/loans/{loanId}/payments")
    fun getPaymentResponse(@Path("personId") personId: Long, @Path("loanId") loanId: Long): Call<PaymentResponse>

}