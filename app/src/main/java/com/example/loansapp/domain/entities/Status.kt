package com.example.loansapp.domain.entities

enum class Status(id: Int) {
    NO_ACTION(0),
    SUCCESSFUL(1),
    NOT_SUCCESSFUL(2),
    LOGIN_IS_EMPTY_ERROR(3)
}