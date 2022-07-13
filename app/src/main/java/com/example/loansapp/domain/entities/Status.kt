package com.example.loansapp.domain.entities

enum class Status(id: Int) {
    NO_ACTION(0),
    SUCCESSFUL(1),
    NOT_SUCCESSFUL(2),
    PHONE_IS_WRONG(3)
}