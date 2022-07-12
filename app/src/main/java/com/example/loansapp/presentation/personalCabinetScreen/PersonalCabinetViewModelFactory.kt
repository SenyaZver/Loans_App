package com.example.loansapp.presentation.personalCabinetScreen

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PersonalCabinetViewModelFactory(private var login: String) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PersonalCabinetViewModel(login) as T
    }

}