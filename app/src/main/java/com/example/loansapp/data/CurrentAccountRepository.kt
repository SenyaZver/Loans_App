package com.example.loansapp.data

import com.example.loansapp.domain.entities.Account
import com.example.loansapp.domain.entities.User


class CurrentAccountRepository {
    private var account : Account? = null
    private var user: User? = null


    fun setUser(newUser: User) {
        user = newUser
    }
    fun getUser() : User {
        return user as User
    }

    fun getId(): Long?{
        return account?.id
    }
    fun setId(newId: Long) {
        account?.id = newId
    }

    fun getPhone(): String? {
        return account?.phone
    }
    fun getPassword(): String? {
        return account?.password
    }
    fun getAccount(): Account {
        return account as Account
    }

    fun setAccount(newAccount: Account) {
        account = newAccount
    }

}