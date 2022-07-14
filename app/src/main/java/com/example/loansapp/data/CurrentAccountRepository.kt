package com.example.loansapp.data

import com.example.loansapp.domain.entities.Account
import com.example.loansapp.domain.entities.User
import kotlinx.coroutines.flow.MutableStateFlow


class CurrentAccountRepository {
    private var account : Account? = null
    private var user = MutableStateFlow(User(-1,"","", null,0, 0, 0,null))

    fun getUserFlow() : MutableStateFlow<User> {
        return user
    }
    fun setUser(newUser: User) {
        user.value = newUser
    }

    fun getUser() : User {
        return user.value
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