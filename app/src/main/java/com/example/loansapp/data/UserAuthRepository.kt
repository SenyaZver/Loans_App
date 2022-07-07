package com.example.loansapp.data

import com.example.loansapp.domain.entities.User

class UserAuthRepository() {
    private var usersList: ArrayList<User> = ArrayList<User>()


    //temp solution for testing purposes
    constructor(name: String, password: String) : this() {
        usersList.add(User(name, password))
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