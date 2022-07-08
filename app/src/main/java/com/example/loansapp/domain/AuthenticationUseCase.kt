package com.example.loansapp.domain

import com.example.loansapp.data.UserAuthRepository
import com.example.loansapp.domain.entities.Status
import com.example.loansapp.domain.entities.User

class AuthenticationUseCase {
    private var userAuthRepository = UserAuthRepository()


    fun execute(user: User): Status {
        //TODO use "when"
        if (userAuthRepository.findUser(user)) {
            return Status.SUCCESSFUL
        }
        if (!userAuthRepository.findUser(user)) {
            return Status.NOT_SUCCESSFUL
        }
        return Status.NO_ACTION
    }
}