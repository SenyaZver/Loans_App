package com.example.loansapp.data.providers

import com.example.loansapp.domain.entities.User

class UserDataProvider(login:String) {

    //temp solution
    fun provide(): User {
        val user = User(1,
            "Arseny",
            "Stuchinsky",
            null,
            10000,
            1255,
            848549,
            "89137903071",
            "sashko1337@mail.ru",
            null)
        return user
    }

}