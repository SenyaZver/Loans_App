package com.example.loansapp.data

import com.example.loansapp.domain.entities.User

class AuthDataProvider {

    //temp solution
    fun getUsers(): ArrayList<User> {
        var result = ArrayList<User>()
        result.add(User("Arseny", "password"))
        return result
    }
}