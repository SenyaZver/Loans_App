package com.example.loansapp.presentation.personalCabinetScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loansapp.R
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loansapp.domain.entities.Loan


class PersonalCabinetActivity : AppCompatActivity() {
    private lateinit var welcomeTextView: TextView
    private lateinit var loansList: RecyclerView
    private var loans: ArrayList<Loan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_cabinet)

        val login = intent.extras!!.getString("login")
        welcomeTextView = findViewById(R.id.welcomeTextView)
        welcomeTextView.text = "Привет, $login"


        loansList = findViewById(R.id.recyclerView)
        loansList.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(loans)
        loansList.adapter = adapter



    }
}


