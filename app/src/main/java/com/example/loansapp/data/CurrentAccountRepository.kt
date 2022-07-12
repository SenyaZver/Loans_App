package com.example.loansapp.data

import com.example.loansapp.domain.entities.Account


class CurrentAccountRepository {
    private var account : Account? = null


    fun getLogin(): String? {
        return account?.login
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