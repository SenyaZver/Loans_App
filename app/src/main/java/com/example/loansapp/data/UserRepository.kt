package com.example.loansapp.data

import com.example.loansapp.data.providers.UserDataProvider
import com.example.loansapp.domain.entities.User

class UserRepository(login: String) {
    private var user: User
    private var userDataProvider = UserDataProvider(login)

    init {
        user = userDataProvider.provide()
    }


    fun getUser(): User {
        return user
    }

    fun getBalace(): Int {
        return user.balance
    }




}