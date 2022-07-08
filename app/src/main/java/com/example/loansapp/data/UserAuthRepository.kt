package com.example.loansapp.data

import com.example.loansapp.domain.entities.User

class UserAuthRepository() {
    private var usersList: ArrayList<User> = ArrayList()
    private var authDataProvider: AuthDataProvider

    init {
        authDataProvider = AuthDataProvider()
        usersList = authDataProvider.getUsers()
    }

    fun findUser(user: User): Boolean {
        for (item in usersList) {
            if (item == user) {
                return true
            }
        }
        return false
    }

}