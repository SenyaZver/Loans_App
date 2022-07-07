package com.example.loansapp.presentation.personalCabinetScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.loansapp.R

class PersonalCabinetActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_cabinet)

        val login = intent.extras!!.getString("login")
        welcomeTextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text = "Привет, $login"



    }
}


